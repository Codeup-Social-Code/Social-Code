package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Post;
import dev.socialcode.socialcode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername (String username);


}
