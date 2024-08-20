package org.studyalone.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.studyalone.domain.Count;
import org.studyalone.dto.CountDto;
import org.studyalone.repository.CountRepository;

@RequiredArgsConstructor
@Service
public class CountService {

    private final CountRepository countRepository;

    public Count save(CountDto dto){
        return countRepository.save(dto.toEntity());

    }

    public Count getClickCount() {
        // 데이터베이스에서 클릭 수를 가져오는 로직
        return countRepository.findById(1L)
                .orElse(Count.builder().num(0).build());
    }
}
