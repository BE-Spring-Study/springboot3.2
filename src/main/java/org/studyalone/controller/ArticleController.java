package org.studyalone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articels/new")
        public String newArticleForm(){
            return "new";
        }

    @PostMapping("/article/create")             //URL 요청 접수
        public String createArticle(){          //메서드 생성 및 반환값 작성
        return ""; //빈칸
    }
}
