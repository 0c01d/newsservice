package com.news.web.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@Data
@Accessors(chain = true)
public class NewsRequest {

    @NotEmpty(message = "Enter content")
    @Size(min = 10, max = 10000, message = "Size invalid")
    private String newscontent;
}
