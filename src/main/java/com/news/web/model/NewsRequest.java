package com.news.web.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;


public class NewsRequest {

    @Size(min = 10, max = 10000, message = "Size invalid")
    private String newscontent;

    public String getNewscontent() {
        return newscontent;
    }

    public NewsRequest(@JsonProperty("newsContent") String newscontent){
        this.newscontent = newscontent;
    }
}
