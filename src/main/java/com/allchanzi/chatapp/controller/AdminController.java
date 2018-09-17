package com.allchanzi.chatapp.controller;

import com.allchanzi.chatapp.model.User;
import com.allchanzi.chatapp.service.MessageService;
import com.allchanzi.chatapp.service.RoleService;
import com.allchanzi.chatapp.service.RoomService;
import com.allchanzi.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author allchanzi
 * @project chatapp
 * @date 9/7/2018
 */

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/admin")
public class AdminController {


    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private RoleService roleService;

    //GET methods
    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    //POST methods

    //UPDATE methods

    //DELETE methods

}
