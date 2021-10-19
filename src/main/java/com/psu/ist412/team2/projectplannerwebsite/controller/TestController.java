package com.psu.ist412.team2.projectplannerwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/account")
public class TestController {
    @GetMapping
    public String getTestPage() {
        return "test";
    }
}
