package com.api.col_trendsback.utils;

public class QueryParameters {
    private long idUserQuery;
    private String[] fields;
    private String filter, order;
    private boolean desc;
    public QueryParameters(String[] fields, String filter, String order, boolean desc) {
        this.fields = fields;
        this.filter = filter;
        this.order = order;
        this.desc = desc;
    }
    
    public QueryParameters(long idUserQuery) {
        this.idUserQuery = idUserQuery;
    }

    public String[] getFields() {
        return fields;
    }
    public String getFilter() {
        return filter;
    }
    public String getOrder() {
        return order;
    }
    public boolean isDesc() {
        return desc;
    }

    public long getIdUserQuery() {
        return this.idUserQuery;
    }
}
