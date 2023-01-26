package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    //param with httpRequest
//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println("hello "+name +" "+surname);
//        return "first/hello";
//    }

    //param with annotation required = for obligatory/non obligatory param input to url
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name,
    @RequestParam(value = "surname",required = false) String surname) {
        System.out.println("hello "+name +" "+surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
