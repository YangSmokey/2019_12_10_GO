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
    public ModelAndView springs(){

        List<Spring> versions = new ArrayList();
        Spring spring1 = new Spring();
        spring1.setVersion("2.2.2 CURRENT GA");
        spring1.setReference("https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/html/");
        spring1.setApi("https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/api/");

        Spring spring2 = new Spring();
        spring2.setVersion("2.2.3 SNAPSHOT");
        spring2.setReference("https://docs.spring.io/spring-boot/docs/2.2.3.BUILD-SNAPSHOT/reference/html/");
        spring2.setApi("https://docs.spring.io/spring-boot/docs/2.2.3.BUILD-SNAPSHOT/api/");

        Spring spring3 = new Spring();
        spring3.setVersion("2.1.12 SNAPSHOT");
        spring3.setReference("https://docs.spring.io/spring-boot/docs/2.1.12.BUILD-SNAPSHOT/reference/html/");
        spring3.setApi("https://docs.spring.io/spring-boot/docs/2.1.12.BUILD-SNAPSHOT/api/");

        Spring spring4 = new Spring();
        spring4.setVersion("2.1.11 GA");
        spring4.setReference("https://docs.spring.io/spring-boot/docs/2.1.11.RELEASE/reference/html/");
        spring4.setApi("https://docs.spring.io/spring-boot/docs/2.1.11.RELEASE/api/");

        versions.add(spring1);
        versions.add(spring2);
        versions.add(spring3);
        versions.add(spring4);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("spring");
        modelAndView.addObject("versions",versions);
        return modelAndView;
    }
}
