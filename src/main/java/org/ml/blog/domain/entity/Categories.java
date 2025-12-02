package org.ml.blog.domain.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.Date;

/**
 * 分类表
 *
 * @TableName categories
 */

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Categories implements Serializable {

    /**
     * 分类ID
     */
    @NotNull(message = "[分类ID]不能为空")
    @Schema(description = "分类ID")

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;
    /**
     * 分类名称
     */
    @NotBlank(message = "[分类名称]不能为空")
    @Size(max = 50, message = "编码长度不能超过50")
    @Schema(description = "分类名称")

    private String name;
    /**
     * 父分类ID，自关联 categories.id
     */
    @Schema(description = "父分类ID，自关联 categories.id")
    private String parentId;
    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createdAt;


}
