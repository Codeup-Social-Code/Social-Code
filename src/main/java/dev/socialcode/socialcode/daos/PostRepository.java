package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByUser_Id(long id);


    @Query("from Post p inner join p.categories c where c.id = ?1")
    List<Post> searchByCategoryId(long id);

   
@Query("from Post p where p.title like %:term% OR p.body like %:term% OR p.user.firstName like %:term% OR p.user.lastName like %:term% OR p.user.username like %:term%")
List<Post> searchByTerm(@Param("term") String term);


    List<Post> findTop9ByOrderByIdDesc();
@Query("from Post p where p.title like %:term%")
List<Post> searchByTitleLike(@Param("term") String term);


}
