package com.allchanzi.chatapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/24/2018
 */

@Entity
@Table(name = "rooms")
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rooms")
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private String title;

    private Boolean locked;

    @ManyToOne
    @JoinColumn(name = "id_users_owner")
    private User user_owner;

    @OneToMany(mappedBy = "room")
    @JsonManagedReference
    private Set<UserRoom> userRoom = new HashSet<UserRoom>();


    public Room(){}

    public Room(Date created, String title, Boolean locked, User user_owner) {
        this.created = created;
        this.title = title;
        this.locked = locked;
        this.user_owner = user_owner;
    }

    public Set<UserRoom> getUserRoom() { return userRoom; }

    public void setUserRoom(Set<UserRoom> userRoom) { this.userRoom = userRoom; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Date getCreated() { return created; }

    public void setCreated(Date created) { this.created = created; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public User getUser_owner() {
        return user_owner;
    }

    public void setUser_owner(User user_owner) {
        this.user_owner = user_owner;
    }
}
