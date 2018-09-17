package com.allchanzi.chatapp.controller;

import com.allchanzi.chatapp.model.Room;
import com.allchanzi.chatapp.service.RoomService;
import com.allchanzi.chatapp.service.UserService;
import com.allchanzi.chatapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/27/2018
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;


    //GET methods

    @RequestMapping("")
    public User user(Principal principal) {
        User user = (User) principal ;
        return user;
    }

    @RequestMapping("/roles")
    public Set<String> getRoles(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .map(r -> r.getAuthority()).collect(Collectors.toSet());
    }

//    @RequestMapping("/rooms")
//    public Set<Room> getUserRooms(Principal user){
//        return userService.getUserRooms(id);
//    }

    //POST methods

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }



    //UPDATE methods
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {userService.addUser(user);}




    //update user info
    //leave room


    //DELETE methods
    //delete user account


    @RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE)
    public void leaveRoom(@PathVariable Integer id, Principal user){
        Room room = roomService.getRoomById(id);
        userService.leaveRoom(room, user.getName());

    }

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }












}
