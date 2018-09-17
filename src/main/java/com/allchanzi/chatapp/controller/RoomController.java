package com.allchanzi.chatapp.controller;

import com.allchanzi.chatapp.model.Room;
import com.allchanzi.chatapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/30/2018
 */

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;


    //GET methods
    //all unlocked rooms
    //room by name

    //POST methods
    //create room


    //UPDATE methods
    //change room name
    //ban user from room

    //DELETE methods
    //remove room


    @RequestMapping("")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void createRoom(@RequestBody Room room){
        roomService.createRoom(room);
    }

}
