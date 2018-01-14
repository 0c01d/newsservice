package com.news.web.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentNewsRequest {

    @Size(min = 2, max = 500, message = "Size invalid")
    private String comment;

    @NotNull
    private Long newsId;

    @NotNull
    private String nickname;

    public String getComment() {
        return comment;
    }
    public Long getNewsId() {
        return newsId;
    }
    public String getNickname() {
        return nickname;
    }

    public CommentNewsRequest(@JsonProperty("comment") String comment,
                              @JsonProperty("newsId") Long newsId,
                              @JsonProperty("nickname") String nickname) {
        this.comment = comment;
        this.newsId = newsId;
        this.nickname = nickname;
    }
}
