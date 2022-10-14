package com.example.pract1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String Main(Model model){
        return "get";
    }

//    @GetMapping("/")
//    public String Get(Model model){
//        return "main";
//    }
//
//    @GetMapping("/")
//    public String Post(Model model){
//        return "main";
//    }

    @GetMapping("/get")
    public String GetController ( @RequestParam(value = "a", required = false) int a,
                                  @RequestParam(value = "b", required = false) int b,
                                  @RequestParam(value = "action", required = false) String action, Model model){
//        model.addAttribute("a", a);
//        model.addAttribute("b", b);
//        model.addAttribute("action", action);

        double result;
        switch (action) {
            case "plus":
                result = a + b;
                break;
            case "min":
                result = a - b;
                break;
            case "multi":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "get";
    }

    @PostMapping("/post")
    public String PostController(@RequestParam int a, @RequestParam int b,
                                 @RequestParam String action, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("action", action);

        double result;

        switch (action) {
            case "plus":
                result = a + b;
                break;
            case "min":
                result = a - b;
                break;
            case "multi":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);

        return "get";
    }

}



