package org.ml.blog.repository;


import org.ml.blog.domain.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, String> {
    void deleteMenuById(String id);

    Menu findMenuById(String id);
}
