package com.news.service.jpa;

import com.news.domain.CommentNews;
import com.news.repository.CommentNewsRepository;
import com.news.service.CommentNewsService;
import com.news.web.model.CommentNewsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentNewsServiceImpl implements CommentNewsService {

    private final CommentNewsRepository commentNewsRepository;

    @Autowired
    public CommentNewsServiceImpl(CommentNewsRepository commentNewsRepository) {
        this.commentNewsRepository = commentNewsRepository;
    }

    @Override
    @Transactional
    public CommentNews createCommentForNews(CommentNewsRequest commentNewsRequest) {
        CommentNews commentNews = new CommentNews();
                commentNews.setComment(commentNewsRequest.getComment());
                commentNews.setIdNews(commentNewsRequest.getNewsId());
                commentNews.setName(commentNewsRequest.getNickname());
        return commentNewsRepository.save(commentNews);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CommentNews> getListCommentsNews(Integer page, Integer size) {
        if(page == null)
            page = 0;
        if(size == null)
            size = 5;
        return commentNewsRepository.findAll(PageRequest.of(page, size));
    }
}
