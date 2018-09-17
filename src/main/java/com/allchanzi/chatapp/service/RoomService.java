package com.allchanzi.chatapp.service;

import com.allchanzi.chatapp.model.Room;
import com.allchanzi.chatapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/27/2018
 */

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomService(){

    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public void createRoom(Room room){
        roomRepository.save(room);
    }

    public Room getRoomById(Integer id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()){
            return room.get();
        } else {
            return null;
        }

    }
}
