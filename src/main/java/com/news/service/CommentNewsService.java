package com.news.service;

import com.news.domain.CommentNews;
import com.news.web.model.CommentNewsRequest;
import org.springframework.data.domain.Page;

public interface CommentNewsService {

    Page<CommentNews> getListCommentsNews(Integer page, Integer size);

    CommentNews createCommentForNews(CommentNewsRequest commentNewsRequest);

}
