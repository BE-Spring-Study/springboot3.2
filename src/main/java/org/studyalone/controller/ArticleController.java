package org.studyalone.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.studyalone.domain.Article;
import org.studyalone.dto.ArticleForm;
import org.studyalone.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Slf4j   //컨트롤러에 로그 남기기(println() 대체)
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
        public String newArticleForm(){
            return "new";
        }

    @PostMapping("/articles/create")             //URL 요청 접수
        public String createArticle(ArticleForm form){          //메서드 생성 및 반환값 작성
        //System.out.println(form.toString());
        log.info(form.toString());

        //DTO를 엔터티를 변환
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(form.toString());

        //리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(form.toString());

        return ""; //빈칸
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id); //id를 잘 받았는지 확인하는 로그 찍기

        // 1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        // 3. 뷰 페이지 변환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {

        //모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();

        //모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
        //뷰 페이지 설정하기
        return "articles/index";
    }
}
