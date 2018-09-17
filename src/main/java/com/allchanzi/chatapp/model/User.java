package com.allchanzi.chatapp.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;


/**
 * @author allchanzi
 * @project chatapp
 * @date 8/24/2018
 */


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_users")
    private Integer id;


    @NotNull
    private String answer;


    @NotNull
    private String email;


    @NotNull
    private String login;


    @NotNull
    private String name;


    @NotNull
    private String surname;


    @NotNull
    private String password;


    @NotNull
    private String question;


    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date registered;

    private String gender;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<UserRoom> userRoom = new HashSet<UserRoom>();


    //Another way to make many to many mapping without creating new class
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_users", referencedColumnName = "id_users"),
            inverseJoinColumns = @JoinColumn(name = "id_roles", referencedColumnName = "id_roles"))
    private List<Role> roles = new ArrayList<>();

    public User() {}

    public User(String answer, String email, String login, String name, String password, String question, Date registered, String surname) {
        this.answer = answer;
        this.email = email;
        this.login = login;
        this.name = name;
        this.password = password;
        this.question = question;
        this.registered = registered;
        this.surname = surname;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Set<UserRoom> getUserRoom() { return userRoom; }

    public void setUserRoom(Set<UserRoom> userRoom) {
        this.userRoom = userRoom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void leaveRoom(Room room){
        userRoom.forEach(ur -> {
            if (ur.getRoom().equals(room) && ur.getUser().equals(this)){
                ur.getRoom().getUserRoom().remove(ur);
                userRoom.remove(ur);
                ur.setRoom(null);
                ur.setUserId(null);

            }
        });
    }

    public void enterRoom(Room room) {
        UserRoom userRoom = new UserRoom(this, room);
        this.userRoom.add(userRoom);
        room.getUserRoom().add(userRoom);
    }
}
