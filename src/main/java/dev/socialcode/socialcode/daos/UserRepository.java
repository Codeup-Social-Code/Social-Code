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


    // Hibernate QL method NOT MySQL
    @Query("FROM User AS u WHERE u.firstName LIKE %:term%")
    List<User> searchByFirstNameLike(@Param("term") String term);

    @Query("FROM User AS u WHERE u.lastName LIKE %:term%")
    List<User> searchByLastNameLike(@Param("term") String term);

    // Combine these two queries up there
    @Query("FROM User AS u WHERE u.firstName LIKE %:term% OR u.lastName LIKE %:term%")
    List<User> searchByNameLike(@Param("term") String term);

    byte countByFollowers(User user);





}
