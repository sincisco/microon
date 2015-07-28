package com.zijin.microon.model;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private Date issuedate;

    private Integer authorno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Integer getAuthorno() {
        return authorno;
    }

    public void setAuthorno(Integer authorno) {
        this.authorno = authorno;
    }
}