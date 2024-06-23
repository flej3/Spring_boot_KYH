package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeConroller {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
