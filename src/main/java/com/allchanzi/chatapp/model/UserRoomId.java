package com.allchanzi.chatapp.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/26/2018
 */

public class UserRoomId implements Serializable {


    private Integer user;

    private Integer room;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoomId that = (UserRoomId) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, room);
    }
}
