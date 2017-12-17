package com.news.web.controller;

import com.news.domain.News;
import com.news.service.NewsService;
import com.news.web.model.NewsRequest;
import com.news.web.model.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public NewsResponse createNews(@Valid @RequestBody NewsRequest newsRequest, HttpServletResponse response) {
        News news = newsService.createNews(newsRequest);
        response.addHeader(HttpHeaders.LOCATION, "/news/" + news.getId());
        return new NewsResponse(news);
    }

    @RequestMapping(value = "/{newsId}", method = RequestMethod.PATCH)
    public NewsResponse updateNews(@PathVariable("newsId") final Integer newsId,@Valid @RequestBody NewsRequest newsRequest) {
        return new NewsResponse(newsService.updateNews(newsId, newsRequest));
    }

    @RequestMapping(value = "/{newsId}", method = RequestMethod.GET)
    public NewsResponse getNewsById(@PathVariable("newsId") Integer newsId) {
        return new NewsResponse(newsService.getNewsById(newsId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<NewsResponse> getNewsList(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        Page<News> newsPage = newsService.getNewsList(page, size);
        return newsPage
                .stream()
                .map(NewsResponse::new)
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{newsId}", method = RequestMethod.DELETE)
    public void deleteNews(@PathVariable Integer newsId) {
        newsService.deleteNews(newsId);
    }
}