package com.allchanzi.chatapp.service;

import com.allchanzi.chatapp.model.Message;
import com.allchanzi.chatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/27/2018
 */

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public MessageService(){

    }

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }
}
