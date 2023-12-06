package org.studyalone.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

@Entity
@AllArgsConstructor     //생성자를 대체하는 어노테이션 / 롬복 추가
@NoArgsConstructor
@ToString
//@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 id 자동생성
    private Long id;

    @Column
    private String title;
    @Column
    private String content;

    public Long getId() {
        return id;
    }

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.title != null)
            this.title = article.content;
    }

    // 어노테이션 추가
//    public String getId() {
//    }


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
