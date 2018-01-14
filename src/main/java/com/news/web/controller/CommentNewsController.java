package com.news.web.controller;

import com.news.domain.CommentNews;
import com.news.service.CommentNewsService;
import com.news.web.model.CommentNewsRequest;
import com.news.web.model.CommentNewsResponse;
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
@RequestMapping("/chatnews")
public class CommentNewsController {

    private final CommentNewsService commentNewsService;

    @Autowired
    public CommentNewsController(CommentNewsService commentNewsService){
        this.commentNewsService = commentNewsService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public CommentNewsResponse createCommentForNews(@Valid @RequestBody CommentNewsRequest commentNewsRequest, HttpServletResponse response) {
        CommentNews commentNews = commentNewsService.createCommentForNews(commentNewsRequest);
        response.addHeader(HttpHeaders.LOCATION, "/chatnews/" + commentNews.getId());
        return new CommentNewsResponse(commentNews);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CommentNewsResponse> getListCommentsNews(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        Page<CommentNews> commentNewsPage = commentNewsService.getListCommentsNews(page, size);
        return commentNewsPage
                .stream()
                .map(CommentNewsResponse::new)
                .collect(Collectors.toList());
    }
}
