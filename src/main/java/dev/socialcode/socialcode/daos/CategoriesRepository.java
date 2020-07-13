package dev.socialcode.socialcode.daos;

import dev.socialcode.socialcode.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
    Category findCategoryById(Long id);

}
