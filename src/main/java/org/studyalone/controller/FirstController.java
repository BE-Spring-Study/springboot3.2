package org.studyalone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    //greetings.mustache 파일 형식과 맞지 않으므로 오류
//    @GetMapping("/hi")
//    public String niceToMeetYou(){
//        return "greetings";
//    }

    @GetMapping("/hi_juheun")
    public String niceToMeetYou(Model model) {
        //addAttribute("변수명", "변숫값")
        model.addAttribute("username", "juheun");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("username", "주흔씨");
        return "goodbye";
    }

    @GetMapping("/layout")
    public String niceToMeetYou_layout(Model model) {
        //addAttribute("변수명", "변숫값")
        model.addAttribute("username", "juheun");
        return "layoutstudy";
    }
}
