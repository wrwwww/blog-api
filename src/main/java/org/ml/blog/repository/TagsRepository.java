package org.ml.blog.repository;


import org.ml.blog.domain.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, String> {
    void deleteTagsById(String id);

    Tags findTagsById(String id);
}
