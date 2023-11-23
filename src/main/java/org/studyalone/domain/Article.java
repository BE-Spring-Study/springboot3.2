package org.studyalone.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

@Entity
@AllArgsConstructor     //생성자를 대체하는 어노테이션 / 롬복 추가
@NoArgsConstructor
@ToString
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;
    @Column
    private String content;


    //마우스 오른쪽 클릭 > Generate -> Constructor == 생성자 자동추가
//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }
//
//    //마우스 오른쪽 클릭 > Generate -> toString()
//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
}
