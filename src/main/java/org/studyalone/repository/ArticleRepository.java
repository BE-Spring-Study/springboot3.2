package org.studyalone.repository;

import org.springframework.data.repository.CrudRepository;
import org.studyalone.domain.Article;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();
}
