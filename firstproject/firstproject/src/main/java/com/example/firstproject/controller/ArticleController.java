package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {

    @Autowired  // 스프링부트가 미리 생성해놓은 객체를 가져다가 자동으로 연결해줌
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")    // 브라우저 주소 설정
    public String newArticleForm(){
        return "articles/new";
    }

    /** Receive data sent by post method from From */
    @PostMapping("/articles/create")
    public String createArticleForm(ArticleForm form){ // Form data를 DTO라는 객체로 만들어서 받음
        // post방식으로 던진 data가 DTO객체(ArticleForm)의 parameter(form)으로 던져짐
        log.info(form.toString());
        // System.out.println(form.toString());

        /** Create data with JPA and H2 */
        // step 1) Make entity class (/entity/Article.java)
        // step 2) Translate DTO(form data) to entity, so that DB can understand JAVA language
        Article artile = form.toEntity();   // Create an entity (define toEntity() in ArticleForm)
        log.info(artile.toString());
        // System.out.println(artile.toString());

        // step 3) Make Repository interface (/repository/ArticleRepository)
        // step 4) Repository saves the entity in DB
        Article saved = articleRepository.save(artile);
        log.info(saved.toString());
        //System.out.println(saved.toString());

       return "";
    }
}
