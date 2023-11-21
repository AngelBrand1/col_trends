package com.api.col_trendsback.models;

import autovalue.shaded.org.jetbrains.annotations.NotNull;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "userquery")
public class UserQuery {
    public UserQuery(String userName, String comment, String queryText) {
        this.userName = userName;
        this.comment = comment;
        this.queryText = queryText;
    }
    
    public UserQuery() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @Column(name = "username")
    @NonNull
    private String userName;

    @Column(name = "comment")
    @NotNull
    private String comment;

    @Column(name = "querytext")
    @NotNull
    private String queryText;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public Long getId() {
        return id;
    }
}
