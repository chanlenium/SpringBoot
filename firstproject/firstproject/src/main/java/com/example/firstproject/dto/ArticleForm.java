package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

/** Form data를 받아올 그릇 */
@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;
    private String content;

//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//
//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    public Article toEntity() {
        return new Article(null, this.title, this.content);
    }
}
