package com.news.web;

import com.news.domain.News;
import com.news.repository.NewsRepository;
import com.news.web.model.NewsRequest;
import com.news.web.model.NewsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@DisplayName("NewsController Test")
class NewsControllerTest {

    private final News news = new News()
            .setId(1)
            .setNewscontent("Content");

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private NewsRepository newsRepositoryMock;

    @Test
    @DisplayName("Create News Test")
    void createNews() {
        News newsNoId = new News()
                .setNewscontent("Content");
        when(newsRepositoryMock.save(newsNoId)).thenReturn(news);

        NewsRequest newsRequest = new NewsRequest()
                .setNewscontent(news.getNewscontent());

        NewsResponse expectedResponse = new NewsResponse(news);

        NewsResponse actualResponse = restTemplate.postForObject("/news/", newsRequest, NewsResponse.class);

        verify(newsRepositoryMock, times(1)).save(newsNoId);
        assertEquals("Invalid user response", expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Get News")
    void getNews(){
        Optional<News> newsOptional = Optional.of(news);

        when(newsRepositoryMock.findById(1)).thenReturn(newsOptional);

        NewsResponse expectedResponse = new NewsResponse(news);
        NewsResponse actualResponse = restTemplate.getForObject("/news/1", NewsResponse.class);

        verify(newsRepositoryMock, times(1)).findById(1);
        assertEquals("Invalid car response", expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Update News")
    void updateNews(){
        News newsUpdate = new News()
                .setId(1)
                .setNewscontent("CONTENT");

        Optional<News> newsOptional = Optional.of(news);

        when(newsRepositoryMock.findById(1)).thenReturn(newsOptional);
        when(newsRepositoryMock.save(any(News.class))).thenReturn(newsUpdate);

        NewsRequest newsRequest = new NewsRequest()
                .setNewscontent("CONTENT");

        NewsResponse expectedResponse = new NewsResponse(news);
        expectedResponse.setNewscontent("CONTENT");
        NewsResponse actualResponse = restTemplate.patchForObject("/news/1", newsRequest, NewsResponse.class);

        verify(newsRepositoryMock, times(1)).findById(1);
        verify(newsRepositoryMock, times(1)).save(newsUpdate);
        assertEquals("Invalid profile response", expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Delete news")
    void deleteNews() {
        restTemplate.delete("/news/1");
        verify(newsRepositoryMock, times(1)).deleteById(1);
    }

}
