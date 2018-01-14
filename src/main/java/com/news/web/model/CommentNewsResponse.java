package com.news.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.news.domain.CommentNews;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentNewsResponse {

    private Long id;
    private String comment;
    private Long idNews;
    private String name;

    public Long getId() {
        return id;
    }
    public String getComment() {
        return comment;
    }
    public Long getIdNews() {
        return idNews;
    }
    public String getName() {
        return name;
    }

    public CommentNewsResponse(CommentNews commentNews) {
        this.id = commentNews.getId();
        this.comment = commentNews.getComment();
        this.idNews = commentNews.getIdNews();
        this.name = name;
    }
}
