package com.allchanzi.chatapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/26/2018
 */


@Entity
@Table(name = "in_room")
@IdClass(UserRoomId.class)
public class UserRoom {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id_users")
    @JsonBackReference
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_rooms", referencedColumnName = "id_rooms")
    @JsonBackReference
    private Room room;

    @Column(name = "last_message")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMessage;

    @Column(name = "entered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entered;




    public UserRoom() {}

    public UserRoom(User user, Room room){
        this.user = user;
        this.room = room;
        this.entered = new Date();
    }

    public User getUser() { return user; }

    public void setUserId(User user) { this.user = user; }

    public Room getRoom() { return room; }

    public void setRoom(Room room) { this.room = room; }

    public Date getLastMessage() { return lastMessage; }

    public void setLastMessage(Date lastMessage) { this.lastMessage = lastMessage; }

    public Date getEntered() { return entered; }

    public void setEntered(Date entered) { this.entered = entered; }
}
