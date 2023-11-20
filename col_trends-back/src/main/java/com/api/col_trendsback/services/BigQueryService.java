package com.api.col_trendsback.services;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.api.col_trendsback.utils.QueryParameters;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Big Query service, manage the connection with big query and execute the
 * queries.
 */
@Service
public class BigQueryService {
    private static final List<String> VALID_FIELDS = Arrays.asList("percent_gain", "term", "rank", "region");

    /**
     * 
     * @param result Type: TableResult of bigquery.TableResult
     * @return a table result on format Json
     */
    private String convertirTableResultAJson(TableResult result) {

        Gson gson = new Gson();
        JsonObject jsonResult = new JsonObject();
        jsonResult.add("schema", gson.toJsonTree(result.getSchema()));
        jsonResult.addProperty("totalRows", result.getTotalRows());
        JsonArray rowsArray = new JsonArray();
        for (FieldValueList row : result.getValues()) {
            JsonObject rowObject = new JsonObject();
            for (Field field : result.getSchema().getFields()) {
                String fieldName = field.getName();
                FieldValue fieldValue = row.get(fieldName);
                rowObject.add(fieldName, gson.toJsonTree(fieldValue));
            }
            rowsArray.add(rowObject);
        }
        jsonResult.add("rows", rowsArray);
        return gson.toJson(jsonResult);
    }

    /**
     * execute a query
     * 
     * @return a Json result of data obtains of big query
     * @throws Exception
     */
    public String executeQuery(String query) throws Exception {
        BigQuery bigquery = BigQueryOptions.newBuilder().setProjectId("fellow-405319").build().getService();

        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();

        Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).build());
        queryJob = queryJob.waitFor();

        if (queryJob == null) {
            throw

            new Exception("job no longer exists");
        }

        if (queryJob.getStatus().getError() != null) {
            throw

            new Exception(queryJob.getStatus().getError().toString());
        }
        TableResult result = queryJob.getQueryResults();
        return convertirTableResultAJson(result);
    }


    public String buildQuery(QueryParameters queryParameters) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT DISTINCT ");

        Map<String, String> fieldMappings = new HashMap<>();
        fieldMappings.put("region", "region_name");
        fieldMappings.put("percent gain", "percent_gain");

        String[] fields = queryParameters.getFields();
        if (fields != null && fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
                String field = fields[i];
                if (isValidField(field)) {
                    if (fieldMappings.containsKey(field)) {
                        queryBuilder.append(fieldMappings.get(field));
                    } else {
                        queryBuilder.append(field);
                    }
                    if (i < fields.length - 1) {
                        queryBuilder.append(", ");
                    }
                }
            }
        } else {
            queryBuilder.append("*");
        }

        queryBuilder.append(" FROM `bigquery-public-data.google_trends.international_top_rising_terms` WHERE country_name = 'Colombia'");

        String filter = queryParameters.getFilter();
        if (filter != null && !filter.isEmpty()) {
            queryBuilder.append(" AND refresh_date > '").append(filter).append("'");
        }

        String order = queryParameters.getOrder();
        if (order != null && !order.isEmpty()) {
            String orderField = fieldMappings.containsKey(order) ? fieldMappings.get(order) : order;
            queryBuilder.append(" ORDER BY ").append(orderField);
            if (queryParameters.isDesc()) {
                queryBuilder.append(" DESC");
            }
        }
        queryBuilder.append(" LIMIT 50");
        return queryBuilder.toString();
    }

    private boolean isValidField(String field) {
        return VALID_FIELDS.contains(field.replaceAll(" ", "_")); 
    }


}
