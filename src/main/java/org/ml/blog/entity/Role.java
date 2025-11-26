package org.ml.blog.entity;

import java.io.Serializable;

import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
* 角色表
* @TableName role
*/
public class Role implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @Schema(description = "主键")
    private String id;
    /**
    * 角色名
    */
    @Size(max= 10,message="编码长度不能超过10")
    @Schema(description = "角色名")
    private String roleName;
    /**
    * 创建时间
    */
    @Schema(description = "创建时间")
    private Date createdAt;
    /**
    * 更新时间
    */
    @Schema(description="更新时间")
    private Date updatedAt;

    /**
    * 主键
    */
    private void setId(String id){
    this.id = id;
    }

    /**
    * 角色名
    */
    private void setRoleName(String roleName){
    this.roleName = roleName;
    }

    /**
    * 创建时间
    */
    private void setCreatedAt(Date createdAt){
    this.createdAt = createdAt;
    }

    /**
    * 更新时间
    */
    private void setUpdatedAt(Date updatedAt){
    this.updatedAt = updatedAt;
    }


    /**
    * 主键
    */
    private String getId(){
    return this.id;
    }

    /**
    * 角色名
    */
    private String getRoleName(){
    return this.roleName;
    }

    /**
    * 创建时间
    */
    private Date getCreatedAt(){
    return this.createdAt;
    }

    /**
    * 更新时间
    */
    private Date getUpdatedAt(){
    return this.updatedAt;
    }

}
