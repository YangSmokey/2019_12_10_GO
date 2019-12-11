package com.ultron.controller;

import com.ultron.entity.Spring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pixel
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(){
        return "hello";
    }

    @GetMapping("/spring")
    public String spring(){
        return "spring";
    }

    @GetMapping("/springs")
    public ModelAndView springs(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("spring");

        Spring spring = new Spring();
        spring.setVersion("2.2.1");
        spring.setReference("https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/html/");
        spring.setApi("https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/api/");

        List<Spring> list = new ArrayList<>();
        list.add(spring);

        modelAndView.addObject(list);
        return modelAndView;
    }
}
