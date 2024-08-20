package org.studyalone.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.studyalone.domain.Article;


@AllArgsConstructor //롬복추가로 사용 가능
@ToString
public class ArticleForm {


    private Long id;
    private String title;       //제목을 받을 필드
    private String content;     //내용을 받을 필드

    //생성자
    //롬복 생성으로 삭제 가능 (@AllArgsConstrucctor)
//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }


    //@ToString 어노테이션 추가로 삭제 가능
//    @Override
//    public String toString(){
//        return "ArticleForm{ " + "title= '" + title + '\'' + ", content='" + content + '\'' + '}';
//    }

    //생성자 형식에 맞게 작성
    public Article toEntity() {
        return new Article(id, title, content);
    }
}
