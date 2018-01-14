package com.news.domain;

import javax.persistence.*;

@Entity
@Table(name = "chat_news", schema = "news_service")
public class CommentNews {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_nickname")
    private String name;

    @Column(name = "idNews")
    private Long idNews;

    @Column(name = "comment")
    private String comment;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getIdNews() {
        return idNews;
    }
    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentNews(){}

    public CommentNews(String name, Long idNews, String comment) {
        this.name = name;
        this.idNews = idNews;
        this.comment = comment;
    }
}