package com.api.col_trendsback.utils;

public class QueryParameters {
    private String userName;
    private String comment;
    private long idUserQuery;
    private String[] fields;
    private String filter, order;
    private boolean desc;
    public QueryParameters(String[] fields, String filter, String order, boolean desc,String userName) {
        this.fields = fields;
        this.filter = filter;
        this.order = order;
        this.desc = desc;
        this.userName = userName;
    }
    
    public QueryParameters(String userName, long idUserQuery) {
        this.userName = userName;
        this.idUserQuery = idUserQuery; 
    }
    

    public QueryParameters() {
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

    public String getUserName() {
        return userName;
    }

    public String getComment() {
        return comment;
    }
    
}
