package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByPostId(long id);
}
