package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Category;
import dev.socialcode.socialcode.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
    Category findCategoryById(Long id);

    @Query("from Category p where p.name like %:term%")
    List<Category> searchByCategory(@Param("term") String term);

}
