package org.ml.blog.repository;


import org.ml.blog.domain.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, String> {
    void deleteCategoriesById(String id);

    Categories findCategoriesById(String id);
}
