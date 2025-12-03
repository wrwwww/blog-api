package org.ml.blog.domain.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 *
 * @TableName menu
 */

@Entity

@NoArgsConstructor
@Getter
@Setter
@Table(name = "menu", schema = "blog")
public class Menu implements Serializable {

    /**
     * 主键
     */
    @NotNull(message = "[主键]不能为空")
    @Schema(description = "主键")
    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;
    /**
     * 权限名
     */
    @Size(max = 10, message = "编码长度不能超过10")
    @Schema(description = "权限名")
    private String menuName;
    /**
     * 权限类型
     */
    @NotNull(message = "[权限类型]不能为空")
    @Schema(description = "权限类型")
    private Integer menuType;
    /**
     * 父节点id
     */
    @Schema(description = "父节点id")
    private Long parentId;
    /**
     * 是否有父节点
     */
    @NotNull(message = "[是否有父节点]不能为空")
    @Schema(description = "是否有父节点")
    private Integer isParent;
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
