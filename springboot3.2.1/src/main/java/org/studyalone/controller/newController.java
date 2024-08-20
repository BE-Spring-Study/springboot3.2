package org.studyalone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.studyalone.domain.Count;
import org.studyalone.service.CountService;

@Controller

public class newController {

    private CountService countService;

    @Autowired
    public newController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/displayCount")
    public String displayCount(Model model) {
        // 데이터베이스에서 클릭 수를 가져와서 모델에 추가
        Count count = countService.getClickCount();
        model.addAttribute("clickCount", count.getNum());
        return "index"; // countDisplay.mustache 또는 다른 템플릿 이름
    }
}
