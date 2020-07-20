package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Comment;
import dev.socialcode.socialcode.models.Follower;
import dev.socialcode.socialcode.models.RSVP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
    List<Follower> findById(long id);
}
