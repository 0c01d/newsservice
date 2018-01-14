package com.news.domain;

import javax.persistence.*;

@Entity
@Table(name = "news", schema = "news_service")
public class News {

    @Id
    @Column(name = "news_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "newsContent")
    private String newscontent;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNewscontent() {
        return newscontent;
    }
    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent;
    }

    public News(){}

    public News(String newscontent) {
        this.newscontent = newscontent;
    }
}