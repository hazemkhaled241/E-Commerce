package com.hazem.demo.controllers;

import com.hazem.demo.entities.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/message")
    public Message message(){
            return new Message("hello");


    }
}
