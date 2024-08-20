package org.studyalone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.studyalone.domain.Count;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CountDto {
    private int num;

    //생성자를 사용해 객체 생성
    public Count toEntity(){
        return Count.builder()
                .num(num)
                .build();
    }
}

