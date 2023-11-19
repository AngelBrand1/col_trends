package com.api.col_trendsback.services;


import org.springframework.stereotype.Service;


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
 * Big Query service, manage the connection with big query and execute the queries.
 */
@Service
public class BigQueryService {
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
     * @return a Json result of data obtains of big query
     * @throws Exception
     */
    public String executeQuery() throws Exception {
        BigQuery bigquery = BigQueryOptions.newBuilder().setProjectId("fellow-405319").build().getService();

        final String GET_WORD_COUNT = "SELECT distinct term, rank ranking, region_name region FROM `bigquery-public-data.google_trends.international_top_terms` WHERE country_name = 'Colombia' LIMIT 20";
        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(GET_WORD_COUNT).build();

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

}
