package org.ml.blog.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

import java.util.Date;

/**
* 码表值表
* @TableName sys_code_value
*/
public class SysCodeValue implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @Schema(description="")
    private String id;
    /**
    * 码表类型ID，外键引用 sys_code_type.id
    */
    @NotNull(message="[码表类型ID，外键引用 sys_code_type.id]不能为空")
    @Schema(description="码表类型ID，外键引用 sys_code_type.id")
    private String typeId;
    /**
    * 实际存储值，如 admin/draft/published
    */
    @NotBlank(message="[实际存储值，如 admin/draft/published]不能为空")
    @Size(max= 50,message="编码长度不能超过50")
    @Schema(description="实际存储值，如 admin/draft/published")
    private String codeValue;
    /**
    * 显示名称，如 管理员/草稿/已发布
    */
    @NotBlank(message="[显示名称，如 管理员/草稿/已发布]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @Schema(description="显示名称，如 管理员/草稿/已发布")
    private String codeLabel;
    /**
    * 备注
    */
    @Size(max= 255,message="编码长度不能超过255")
    @Schema(description="备注")
    private String description;
    /**
    * 排序，用于前端显示顺序
    */
    @Schema(description="排序，用于前端显示顺序")
    private Integer sortOrder;
    /**
    * 是否启用，0=禁用,1=启用
    */
    @Schema(description="是否启用，0=禁用,1=启用")
    private Integer isActive;
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
    * 
    */
    private void setId(String id){
    this.id = id;
    }

    /**
    * 码表类型ID，外键引用 sys_code_type.id
    */
    private void setTypeId(String typeId){
    this.typeId = typeId;
    }

    /**
    * 实际存储值，如 admin/draft/published
    */
    private void setCodeValue(String codeValue){
    this.codeValue = codeValue;
    }

    /**
    * 显示名称，如 管理员/草稿/已发布
    */
    private void setCodeLabel(String codeLabel){
    this.codeLabel = codeLabel;
    }

    /**
    * 备注
    */
    private void setDescription(String description){
    this.description = description;
    }

    /**
    * 排序，用于前端显示顺序
    */
    private void setSortOrder(Integer sortOrder){
    this.sortOrder = sortOrder;
    }

    /**
    * 是否启用，0=禁用,1=启用
    */
    private void setIsActive(Integer isActive){
    this.isActive = isActive;
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
    * 
    */
    private String getId(){
    return this.id;
    }

    /**
    * 码表类型ID，外键引用 sys_code_type.id
    */
    private String getTypeId(){
    return this.typeId;
    }

    /**
    * 实际存储值，如 admin/draft/published
    */
    private String getCodeValue(){
    return this.codeValue;
    }

    /**
    * 显示名称，如 管理员/草稿/已发布
    */
    private String getCodeLabel(){
    return this.codeLabel;
    }

    /**
    * 备注
    */
    private String getDescription(){
    return this.description;
    }

    /**
    * 排序，用于前端显示顺序
    */
    private Integer getSortOrder(){
    return this.sortOrder;
    }

    /**
    * 是否启用，0=禁用,1=启用
    */
    private Integer getIsActive(){
    return this.isActive;
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
