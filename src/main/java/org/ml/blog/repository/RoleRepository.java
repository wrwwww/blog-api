package org.ml.blog.repository;


import org.ml.blog.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    void deleteRoleById(String id);

    Role findRoleById(String id);
}
