package org.ml.blog.entity;


import java.io.Serializable;

import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
* 分类表
* @TableName categories
*/
public class Categories implements Serializable {

    /**
    * 分类ID
    */
    @NotNull(message="[分类ID]不能为空")
    @Schema(description="分类ID")
    private String id;
    /**
    * 分类名称
    */
    @NotBlank(message="[分类名称]不能为空")
    @Size(max= 50,message="编码长度不能超过50")
    @Schema(description="分类名称")
    private String name;
    /**
    * 父分类ID，自关联 categories.id
    */
    @Schema(description="父分类ID，自关联 categories.id")
    private String parentId;
    /**
    * 创建时间
    */
    @Schema(description="创建时间")
    private Date createdAt;

    /**
    * 分类ID
    */
    private void setId(String id){
    this.id = id;
    }

    /**
    * 分类名称
    */
    private void setName(String name){
    this.name = name;
    }

    /**
    * 父分类ID，自关联 categories.id
    */
    private void setParentId(String parentId){
    this.parentId = parentId;
    }

    /**
    * 创建时间
    */
    private void setCreatedAt(Date createdAt){
    this.createdAt = createdAt;
    }


    /**
    * 分类ID
    */
    private String getId(){
    return this.id;
    }

    /**
    * 分类名称
    */
    private String getName(){
    return this.name;
    }

    /**
    * 父分类ID，自关联 categories.id
    */
    private String getParentId(){
    return this.parentId;
    }

    /**
    * 创建时间
    */
    private Date getCreatedAt(){
    return this.createdAt;
    }

}
