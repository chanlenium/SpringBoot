package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**  Implement MVC pattern
* M : Model
* V : View (resources/templates/greetings.mustache)
* C : Controller (controller/FirstController)
*/

@Controller /** (Step1) Import Controller **/
public class FirstController {
    /** (Step2) Link view(greetings.mustache) to web page
     * client의 `localhost:8080/hi`요청과 동시에 `niceToMeetYou` method 실행
     */
    @GetMapping("/hi") // `http://localhost:8080/hi`web page 주소를 `greetings.mustache`와 연결
    public String niceToMeetYou(Model model){
        /** (Step3) add attribute */
        model.addAttribute("username", "Dongchan");
        return "greetings"; // templates 안에 `greeting.mustache`를 찾아서 브라우저로 전송
        // return 값을 찾아서 view page에 보여줌
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "Damon");
        return "goodbye";
    }
}
