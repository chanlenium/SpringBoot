package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
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
        System.out.println(form.toString());

        /** create data with JPA */
        // 1. dto(form data)를 entity로 변환환
        Article artile = form.toEntity();   // entity 생성
        System.out.println(artile.toString());

        // 2. repository에게 entity를 DB안에 저장하게 함
        Article saved = articleRepository.save(artile);
        System.out.println(saved.toString());

       return "";
    }
}
