package org.ml.blog.entity;


import java.io.Serializable;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 角色表
 *
 * @TableName menu
 */
public class Menu implements Serializable {

    /**
     * 主键
     */
    @NotNull(message = "[主键]不能为空")
    @Schema(description = "主键")
    private String id;
    /**
     * 权限名
     */
    @Size(max = 10, message = "编码长度不能超过10")
    @Schema(description="权限名")
    private String menuName;
    /**
     * 权限类型
     */
    @NotNull(message = "[权限类型]不能为空")
    @Schema(description="权限类型")
    private Integer menuType;
    /**
     * 父节点id
     */
    @Schema(description="父节点id")
    private Long parentId;
    /**
     * 是否有父节点
     */
    @NotNull(message = "[是否有父节点]不能为空")
    @Schema(description="是否有父节点")
    private Integer isParent;
    /**
     * 创建时间
     */
    @Schema(description="创建时间")
    private Date createdAt;
    /**
     * 更新时间
     */
    @Schema(description="更新时间")
    private Date updatedAt;

    /**
     * 主键
     */
    private void setId(String id) {
        this.id = id;
    }

    /**
     * 权限名
     */
    private void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 权限类型
     */
    private void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    /**
     * 父节点id
     */
    private void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 是否有父节点
     */
    private void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    /**
     * 创建时间
     */
    private void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 更新时间
     */
    private void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    /**
     * 主键
     */
    private String getId() {
        return this.id;
    }

    /**
     * 权限名
     */
    private String getMenuName() {
        return this.menuName;
    }

    /**
     * 权限类型
     */
    private Integer getMenuType() {
        return this.menuType;
    }

    /**
     * 父节点id
     */
    private Long getParentId() {
        return this.parentId;
    }

    /**
     * 是否有父节点
     */
    private Integer getIsParent() {
        return this.isParent;
    }

    /**
     * 创建时间
     */
    private Date getCreatedAt() {
        return this.createdAt;
    }

    /**
     * 更新时间
     */
    private Date getUpdatedAt() {
        return this.updatedAt;
    }

}
