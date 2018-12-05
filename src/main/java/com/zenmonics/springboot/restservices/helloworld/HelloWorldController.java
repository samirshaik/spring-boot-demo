package com.zenmonics.springboot.restservices.helloworld;

import com.zenmonics.springboot.restservices.helloworld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = {"/hello/{name}"})
    public String helloName(@PathVariable String name) {
        return "Hello "+ name;
    }

    /**
     * We have configured SessionLocaleResolver in RestServiceApplication.java
     * To have this method working comment out AcceptHeaderLocaleResolver and uncomment SessionLocaleResolver
     * @return
     */
    /*@GetMapping(path = "/good-morning")
    public String internationalizedGoodMorning() {
        return messageSource.getMessage("good.morning.msg", null, LocaleContextHolder.getLocale());
    }*/

    @GetMapping(path = "/good-morning-header")
    public String internationalizedGoodMorningWithRequestHeader() {
        return messageSource.getMessage("good.morning.msg", null, LocaleContextHolder.getLocale());
    }
}
