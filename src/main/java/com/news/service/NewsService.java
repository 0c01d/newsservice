package com.news.service;

import com.news.domain.News;
import com.news.web.model.NewsRequest;
import org.springframework.data.domain.Page;

public interface NewsService {

    News createNews(NewsRequest newsRequest);
    News getNewsById(Long newsId);
    Page<News> getNewsList(Integer page, Integer size);
    News updateNews(Long newsId, NewsRequest newsRequest);
    void deleteNews(Long id);
}
