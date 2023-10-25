package org.studyalone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
    @GetMapping("/quote")
    public String randomQuote(Model model){
        String[] quotes={
                "행복은 습관이다. 그것을 몸에 지니라. " + "- 심주흔",
                "고개 숙이지 마십시오. 세상을 똑바로 정면으로" + "- 심주흔",
                "작은 기회로부터 종종 위대한 업적이 시작된다." + "- 심주흔",
                "나는 생각한다 고로 존재한다." + "- 심주흔"
        };

        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote",quotes[randInt]);
        return "quote";         //mustache 파일 이름
    }
}
