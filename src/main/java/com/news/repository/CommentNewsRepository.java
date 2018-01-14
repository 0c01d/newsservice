package com.news.repository;

import com.news.domain.CommentNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentNewsRepository extends JpaRepository<CommentNews, Long> {
}
