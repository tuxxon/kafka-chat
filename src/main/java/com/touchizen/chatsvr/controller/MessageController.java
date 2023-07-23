package com.touchizen.chatsvr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.touchizen.chatsvr.service.MessageService;

@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String home() {
        return messageService.getMessage();
    }

    @PostMapping("/create")
    public String create(@RequestParam(value = "message", defaultValue = "") String message) {
        if(message.isEmpty()) {
            return "Input a message!";
        }

        String messageInDB = messageService.getMessage();
        if(false == messageInDB.isEmpty()){
            return "Already exist!";
        }
        
        return messageService.createMessage(message);
    }

    @GetMapping("/read")
    public String read() {
        return "redirect:/";
    }

    @GetMapping("/read1")
    public ModelAndView read1() {
        return new ModelAndView("redirect:/");
    }

   @GetMapping("/read2")
   public void read2(HttpServletResponse httpServletResponse) throws IOException {
       httpServletResponse.sendRedirect("/");
   }    

    @PutMapping("/update")
    public String update(@RequestParam(value = "message", defaultValue = "") String message){
        messageService.deleteMessage();
        return messageService.createMessage(message);
    }

    @DeleteMapping("/delete")
    public String delete() {
        messageService.deleteMessage();
        return "";
    }

}