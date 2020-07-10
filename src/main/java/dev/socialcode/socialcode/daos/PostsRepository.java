package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {


}
