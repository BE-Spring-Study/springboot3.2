package org.studyalone.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.studyalone.domain.Article;
import org.studyalone.dto.ArticleForm;
import org.studyalone.repository.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if(article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article updated(Long id, ArticleForm dto) {
        // DTO -> 엔터티 변환하기
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        // 타깃 조회하기
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못된 요청 처리하기
        if (target == null || id != article.getId()){
            log.info("Wrong Access! id : {}, article : {}", id, article.toString());
            return null;
        }

        // 업데이트 및 정상 응답 하기
        target.patch(article);          //기존 데이터에 새 데이터 붙이기
        Article updated = articleRepository.save(article);
        return updated;
    }

    public Article delete(Long id) {
        // 대상찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못 된 요청 처리하기
        if (target == null){
            return null;
        }

        // 대상 삭제하기
        articleRepository.delete(target);
        return target;
        //return ResponseEntity.status(HttpStatus.OK).build(); 와 결과가 같음
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {

        //dto 묶음을 엔티티 묶음으로 변환하기
        List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        //엔티티 묶음을 DB에 저장하기
        articleList.stream().forEach(article -> articleRepository.save(article));

        //강제 예외 발생시키기
        articleRepository.findById(-1L)
                .orElseThrow(()-> new IllegalArgumentException("결제 실패!!"));

        //결과 값 반환하기
        return articleList;
    }
}
