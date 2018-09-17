package com.allchanzi.chatapp.service;

import com.allchanzi.chatapp.model.Room;
import com.allchanzi.chatapp.model.User;
import com.allchanzi.chatapp.model.UserRoom;
import com.allchanzi.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/28/2018
 */

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {

    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }


    public User getUserById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    public User getUserByLogin(String login){
        Optional<User> user = userRepository.findUserByLogin(login);
        if (user.isPresent()){
            return user.get();
        } else {
            return null;
        }
    }

    public void addUser(User user){
        user.setRegistered(new Date());
        userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public Set<Room> getUserRooms(Integer id){
        User user = getUserById(id);
        Set<Room> rooms = new HashSet<>();
        for (UserRoom ur: user.getUserRoom()) {
            rooms.add(ur.getRoom());
        }
        return rooms;

    }

    public void leaveRoom(Room room, String login){
        User user = this.getUserByLogin(login);
        user.leaveRoom(room);

    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByLogin(login);
        if (user.isPresent()){
            return new UserAdapter(user.get());
        } else {
            throw new UsernameNotFoundException(String.format("User with login '%s' doesn't exist!", login));
        }
    }
}
