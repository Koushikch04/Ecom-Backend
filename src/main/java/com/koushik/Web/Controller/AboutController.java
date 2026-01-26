package com.koushik.Web.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

    @RequestMapping("/about")
    public String about(){
        return "I am a Software Engineer Working at Itilite, Current Upskilling, and aiming for big in the career";
    }
}
