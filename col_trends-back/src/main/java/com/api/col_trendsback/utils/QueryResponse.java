package com.api.col_trendsback.utils;

import com.google.cloud.bigquery.*;

public class QueryResponse {
    private long totalRows;
    private Iterable<FieldValueList> values;
    private FieldList fields;

    public QueryResponse(long totalRows, FieldList fields, Iterable<FieldValueList> values) {
        this.totalRows = totalRows;
        this.values = values;
        this.fields = fields;
    }

    public QueryResponse(long totalRows) {
        this.totalRows = totalRows;
        this.values = null;
        this.fields = null;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public Iterable<FieldValueList> getValues() {
        return values;
    }

    public FieldList getFields() {
        return fields;
    }

    public void setFields(FieldList fields) {
        this.fields = fields;
    }

    // public static QueryResponse fromQueryJob(QueryJobConfiguration queryConfig, QueryResponse response) {
    //     BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    //     TableResult result = bigquery.query(queryConfig);
    //     response.setFields(result.getSchema().getFields());
    //     response.setTotalRows(result.getTotalRows());
    //     response.setValues(result.iterateAll());
    //     return response;
    // }
}