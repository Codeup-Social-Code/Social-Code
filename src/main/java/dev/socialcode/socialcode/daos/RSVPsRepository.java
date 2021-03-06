package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Comment;
import dev.socialcode.socialcode.models.RSVP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RSVPsRepository extends JpaRepository<RSVP, Long> {
    List<RSVP> findRSVPSByPostId(long id);
}
