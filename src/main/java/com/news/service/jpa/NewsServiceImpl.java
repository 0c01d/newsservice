package com.news.service.jpa;

import com.news.domain.News;
import com.news.repository.NewsRepository;
import com.news.service.NewsService;
import com.news.web.model.NewsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    @Transactional
    public News createNews(NewsRequest newsRequest) {
        News news = new News();
                news.setNewscontent(newsRequest.getNewscontent());
        return newsRepository.save(news);
    }

    @Override
    @Transactional
    public News updateNews(Long newsId, NewsRequest newsRequest) {
        News news = this.getNewsById(newsId);
        if (news == null) {
            throw new EntityNotFoundException("News '{" + newsId + "}' not found");
        }
//        news.setNewscontent(newsRequest.getNewscontent() != null ? newsRequest.getNewscontent() : news.getNewscontent());
        return newsRepository.save(news);
    }

    @Override
    @Transactional
    public News getNewsById(Long newsId) {
        return newsRepository.findById(newsId)
                .orElseThrow(() -> new EntityNotFoundException("News '{" + newsId + "}' not found"));
    }

    @Override
    @Transactional
    public Page<News> getNewsList(Integer page, Integer size) {
        if(page == null)
            page = 0;
        if(size == null)
            size = 5;
        return newsRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    @Transactional
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
