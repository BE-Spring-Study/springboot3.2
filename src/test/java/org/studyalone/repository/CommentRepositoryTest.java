package org.studyalone.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.studyalone.domain.Article;
import org.studyalone.domain.Comment;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        {
            //입력 데이터 준비
            Long articleId = 4L;

            //실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            //예상 데이터
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글로 써주세요");

            Comment a = new Comment(1L, article, "Park", "굿 월 헌팅");
            Comment b = new Comment(2L, article, "Shim", "아이 앰 샘");
            Comment c = new Comment(3L, article, "KIM", "쇼생크 탈출");

            List<Comment> expected = Arrays.asList(a, b, c);

            //비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");
        }

        {
            //입력 데이터 준비
            Long articleId = 1L;

            //실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            //예상 데이터
            Article article = new Article(1L, "가가가가", "1111");

            List<Comment> expected = Arrays.asList();

            //비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글 없음!");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        {
            // 입력 데이터 준비
            String nickname = "Park";

            //실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);

            //예상 데이터
            Comment a = new Comment(1L, new Article(4L,"당신의 인생 영화는?", "댓글로 써주세요"), nickname, "굿 월 헌팅");
            Comment b = new Comment(4L, new Article(5L,"당신의 소울 푸드는?", "댓글로 써주세요오옹"),nickname, "치킨");
            Comment c = new Comment(7L, new Article(6L,"당신의 취미는?", "댓글로 써주세요이이잉"),nickname, "기타");

            List<Comment> expected = Arrays.asList(a, b, c);

            //비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "Park의 모든 댓글을 출력!");
        }
    }
}