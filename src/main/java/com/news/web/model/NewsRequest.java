package com.news.web.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NewsRequest {
    private String newscontent;
}
