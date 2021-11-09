package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

// JPA에서 제공하는 repository interface활용
public interface ArticleRepository extends CrudRepository<Article, Long> { // Article을 CRUD할 수 있게 CrudRepository를 상속 받음

}
