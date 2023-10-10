package org.studyalone.dto;

public class ArticleForm {

    private String title;       //제목을 받을 필드
    private String content;     //내용을 받을 필드

    //생성자
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
