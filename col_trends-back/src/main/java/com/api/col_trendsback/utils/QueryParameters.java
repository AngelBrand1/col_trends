package com.api.col_trendsback.utils;

public class QueryParameters {
    private String[] topTerms,topRisTerms;
    private String date;
    
    public QueryParameters(String[] topTerms, String[] topRisTerms, String date) {
        this.topTerms = topTerms;
        this.topRisTerms = topRisTerms;
        this.date = date;
    }
    public String[] getTopTerms() {
        return topTerms;
    }
    public String[] getTopRisTerms() {
        return topRisTerms;
    }
    public String getDate() {
        return date;
    }
    


}
