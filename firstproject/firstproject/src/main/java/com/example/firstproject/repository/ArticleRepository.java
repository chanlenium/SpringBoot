package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

/** Use repository interface provided in JPA library
 * CrudRepository<A, B>
 *     A : name of entity class
 *     B : type of primary key
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
    // Inherit a `CrudRepository` to use CRUD operation for Article entity
}
