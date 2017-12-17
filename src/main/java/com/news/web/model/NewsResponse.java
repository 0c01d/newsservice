package com.news.web.model;

import com.news.domain.News;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewsResponse {
    private Integer id;
    private String newscontent;


    public NewsResponse(News news) {
        this.id = news.getId();
        this.newscontent = news.getNewscontent();
    }
}
