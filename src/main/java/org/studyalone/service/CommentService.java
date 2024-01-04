package org.studyalone.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studyalone.domain.Article;
import org.studyalone.domain.Comment;
import org.studyalone.dto.CommentDto;
import org.studyalone.repository.ArticleRepository;
import org.studyalone.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    //외부 객체 주입
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;


    public List<CommentDto> comments(Long articleId) {
//        // 댓글조회
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//
//        // 엔티티 -> DTO 변환
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//        for(int i =0; i < comments.size(); i++){
//            Comment c = comments.get(i);
//            CommentDto dto = CommentDto.createCommentDto(c);
//            dtos.add(dto);
//        }
//
//        // 결과 반환
//        return dtos;
        // stream
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }


    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        // 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패!" + "대상 게시글이 없습니다"));

        //댓글 엔터티 생성
        Comment comment = Comment.createComment(dto, article);

        //댓글 엔티티를 DB에 저장
        Comment created = commentRepository.save(comment);

        // DTO로 변환해 반환
        return CommentDto.createCommentDto(created);
    }
}
