package org.ml.blog.repository;


import org.ml.blog.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    void deleteUserById(String id);

    User findUserById(String id);
}
