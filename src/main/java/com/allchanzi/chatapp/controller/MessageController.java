package com.allchanzi.chatapp.controller;

import com.allchanzi.chatapp.model.Message;
import com.allchanzi.chatapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/30/2018
 */

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    //GET methods
    @RequestMapping("")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    //get room messages
    //

    //POST methods
    //post message


    //UPDATE methods



    //DELETE methods
    //

}
