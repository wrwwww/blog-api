package org.ml.blog.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 码表类型表
 *
 * @TableName sys_code_type
 */
@Entity
@Getter
@NoArgsConstructor
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sys_code_type", schema = "blog")
public class SysCodeType implements Serializable {

    /**
     *
     */
    @Id
    @NotNull(message = "[]不能为空")
    @GeneratedValue
    @UuidGenerator
    private String id;
    /**
     * 码表类型唯一标识，如 role/status/category
     */
    @NotBlank(message = "[码表类型唯一标识，如 role/status/category]不能为空")
    @Size(max = 50, message = "编码长度不能超过50")
    @Schema(description = "码表类型唯一标识，如 role/status/category")
    private String codeType;
    /**
     * 码表类型名称，如 用户角色/文章状态/分类类型
     */
    @NotBlank(message = "[码表类型名称，如 用户角色/文章状态/分类类型]不能为空")
    @Size(max = 100, message = "编码长度不能超过100")
    @Schema(description = "码表类型名称，如 用户角色/文章状态/分类类型")
    private String name;
    /**
     * 说明
     */
    @Size(max = 255, message = "编码长度不能超过255")
    @Schema(description = "说明")
    private String description;

    @CreatedDate
    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Schema(description = "更新时间")
    private LocalDateTime updatedAt;


}
