package com.allchanzi.chatapp.repository;

import com.allchanzi.chatapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author allchanzi
 * @project chatapp
 * @date 9/5/2018
 */
public interface RolesRepository extends JpaRepository<Role, Integer> {

}
