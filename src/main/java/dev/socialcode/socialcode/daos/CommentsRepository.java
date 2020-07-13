package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
