package org.ml.blog.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EntityListeners;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;


@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @CreatedDate
    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Schema(description = "更新时间")
    private LocalDateTime updatedAt;
}
