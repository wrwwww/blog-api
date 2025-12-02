package org.ml.blog.repository;


import org.ml.blog.domain.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Articles, String> {
    void deleteArticlesById(String id);

    Articles findArticlesById(String id);
}
