package org.studyalone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.studyalone.domain.Count;
import org.studyalone.dto.CountDto;
import org.studyalone.repository.CountRepository;
import org.studyalone.service.CountService;

//@Controller
@RestController
@RequestMapping("/counts")
public class testController {

    private CountService countService;

    @Autowired
    public testController(CountService countService) {
        this.countService = countService;
    }
//
//    @GetMapping("/displayCount")
//    public String displayCount(Model model) {
//        // 데이터베이스에서 클릭 수를 가져와서 모델에 추가
//        Count count = countService.getClickCount();
//        model.addAttribute("clickCount", count.getNum());
//        return "index"; // countDisplay.mustache 또는 다른 템플릿 이름
//    }



    @PostMapping("/increase")
    public ResponseEntity<Count> sumCount(@RequestBody CountDto dto) {
        // 클라이언트에서 전달된 데이터(dto)를 이용하여 클릭 수 증가 로직을 수행합니다.
        // 이 로직은 CountService 내에서 구현되어야 합니다.
        Count updatedCount = countService.save(dto);

        if (updatedCount != null) {
            // 클라이언트에 업데이트된 클릭 수를 응답으로 반환합니다.
            return new ResponseEntity<>(updatedCount, HttpStatus.OK);
        } else {
            // 클릭 수 업데이트에 실패한 경우 오류 응답을 반환합니다.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/check")
    public ResponseEntity<Count> checkCount() {
        // 서버에 저장된 클릭 수를 조회합니다.
        Count count = countService.getClickCount();
        if (count != null) {
            // 조회된 클릭 수를 응답으로 반환합니다.
            return new ResponseEntity<>(count, HttpStatus.OK);
        } else {
            // 클릭 수 조회에 실패한 경우 오류 응답을 반환합니다.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}