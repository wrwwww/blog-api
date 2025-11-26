package org.ml.blog.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;

import java.util.Date;

/**
 * 码表类型表
 *
 * @TableName sys_code_type
 */
@Entity
@Getter
@Setter
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
    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createdAt;
    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private Date updatedAt;



}
