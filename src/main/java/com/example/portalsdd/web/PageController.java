package com.example.portalsdd.web;

import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping({"/", "/index"})
    public String index(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        return "index";
    }
}
