package com.ultron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pixel
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("hello","Hello Freemarker");
        return modelAndView;
    }
}
