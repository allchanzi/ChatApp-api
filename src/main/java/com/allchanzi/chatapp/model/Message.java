package com.allchanzi.chatapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/24/2018
 */

@Entity
@Table(name = "messages")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_messages")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_users_from")//, insertable=false, updatable=false)
    private User user_from;

    @ManyToOne
    @JoinColumn(name = "id_users_to")
    private User user_to;

    @ManyToOne
    @JoinColumn(name = "id_rooms")
    private Room room;

    private String message;


    @Temporal(TemporalType.DATE)
    private Date time;


    public Message() {}

    public Message(User user_from, User user_to, Room room, String message, Date time) {
        this.user_from = user_from;
        this.user_to = user_to;
        this.room = room;
        this.message = message;
        this.time = time;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public User getUser_from() { return user_from; }

    public void setUser_from(User user_from) { this.user_from = user_from; }

    public User getUser_to() { return user_to; }

    public void setUser_to(User user_to) { this.user_to = user_to; }

    public Room getRoom() { return room; }

    public void setRoom(Room room) { this.room = room; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public Date getTime() { return time; }

    public void setTime(Date time) { this.time = time; }
}
