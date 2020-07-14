package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.RSVP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RSVPsRepository extends JpaRepository<RSVP, Long> {
}
