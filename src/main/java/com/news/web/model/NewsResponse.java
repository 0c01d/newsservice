package com.news.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.news.domain.News;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsResponse {
    private Long id;
    private String newscontent;

    public Long getId() {
        return id;
    }
    public String getNewscontent() {
        return newscontent;
    }

    public NewsResponse(News news) {
        this.id = news.getId();
        this.newscontent = news.getNewscontent();
    }
}
