package com.koushik.Web.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
//    @ResponseBody  //Not required if we use RestController, required in case we just use controller
    public String greet(){
        System.out.println("This method is hit!");
        return "This is my first Java Controller";
    }
}
