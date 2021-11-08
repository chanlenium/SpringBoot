package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @GetMapping("/articles/new")    // 브라우저 주소 설정
    public String newArticleForm(){
        return "articles/new";
    }

    /** Form에서 post방식으로 던진 data 받기 */
    @PostMapping("/articles/create")
    public String createArticleForm(ArticleForm form){ // Form data를 DTO라는 객체로 만들어서 받음
        // post방식으로 던진 data가 DTO객체(ArticleForm)의 parameter(form)으로 던져짐
        System.out.println(form.toString());
        return "";
    }
}
