package org.studyalone.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.studyalone.domain.Article;
import org.studyalone.dto.ArticleForm;
import org.studyalone.repository.ArticleRepository;

import java.util.List;

@Slf4j
@RestController // 이 클래스가 REST 컨트롤러임을 명시
public class ArticleController2 {


    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleRepository.findById(id).orElse(null);
    }


    @PostMapping("/api/articles")
    public Article create(@RequestBody  ArticleForm dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
        // DTO -> 엔터티 변환하기
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        // 타깃 조회하기
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못된 요청 처리하기
        if (target == null || id != article.getId()){
            log.info("Wrong Access! id : {}, article : {}", id, article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // 업데이트 및 정상 응답 하기
        target.patch(article);          //기존 데이터에 새 데이터 붙이기
        Article updated = articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        // 대상찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못 된 요청 처리하기
        if (target == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // 대상 삭제하기
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).body(null);
        //retunr ResponseEntity.status(HttpStatus.OK).build(); 와 결과가 같음
    }
}
