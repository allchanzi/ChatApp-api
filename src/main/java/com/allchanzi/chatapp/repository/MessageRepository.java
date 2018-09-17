package com.allchanzi.chatapp.repository;

        import com.allchanzi.chatapp.model.Message;
        import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author allchanzi
 * @project chatapp
 * @date 8/27/2018
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
