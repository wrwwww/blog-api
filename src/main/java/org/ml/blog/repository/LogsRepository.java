package org.ml.blog.repository;


import org.ml.blog.domain.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Logs, String> {
    void deleteLogsById(String id);

    Logs findLogsById(String id);
}
