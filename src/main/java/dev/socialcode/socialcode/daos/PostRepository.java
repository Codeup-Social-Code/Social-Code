package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findTop9ByOrderByIdDesc();



}
