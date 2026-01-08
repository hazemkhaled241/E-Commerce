package com.hazem.demo.controllers;

import com.hazem.demo.entities.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.awt.SystemColor.text;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("name","hazem");
        return "index.html";
    }

}
