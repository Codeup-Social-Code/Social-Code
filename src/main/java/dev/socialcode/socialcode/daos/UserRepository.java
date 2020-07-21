package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Post;
import dev.socialcode.socialcode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername (String username);
    User findUsersByPosts_Id(long id);

    @Query("from User u where u.username like %:term%")
    User searchByNameLike(@Param("term") String term);


}
