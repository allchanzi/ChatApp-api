package com.allchanzi.chatapp.repository;

import com.allchanzi.chatapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/27/2018
 */


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByNameOrSurname(String name, String surname);

    Optional<User> findUserByLogin(String login);


}
