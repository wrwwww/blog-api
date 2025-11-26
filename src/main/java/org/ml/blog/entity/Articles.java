package org.ml.blog.entity;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

import java.util.Date;

/**
* 文章表
* @TableName articles
*/
public class Articles implements Serializable {

    /**
    * 文章ID
    */
    @NotNull(message="[文章ID]不能为空")
    @Schema(description="文章ID")
    private String id;
    /**
    * 作者ID，关联 users.id
    */
    @NotNull(message="[作者ID，关联 users.id]不能为空")
    @Schema(description="作者ID，关联 users.id")
    private String authorId;
    /**
    * 文章标题
    */
    @NotBlank(message="[文章标题]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @Schema(description="文章标题")
    private String title;
    /**
    * 文章正文
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @Schema(description="文章正文")
    private String content;
    /**
    * 文章摘要
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @Schema(description="文章摘要")
    private String excerpt;
    /**
    * 封面图URL
    */
    @Size(max= 255,message="编码长度不能超过255")
    @Schema(description="封面图URL")
    private String coverImage;
    /**
    * 文章状态，参照码表
    */
    @Size(max= 50,message="编码长度不能超过50")
    @Schema(description="文章状态，参照码表")
    private String status;
    /**
    * 阅读量
    */
    @Schema(description="阅读量")
    private Integer views;
    /**
    * 创建时间
    */
    @Schema(description="创建时间")
    private Date createdAt;
    /**
    * 最后更新时间
    */
    @Schema(description="最后更新时间")
    private Date updatedAt;

    /**
    * 文章ID
    */
    private void setId(String id){
    this.id = id;
    }

    /**
    * 作者ID，关联 users.id
    */
    private void setAuthorId(String authorId){
    this.authorId = authorId;
    }

    /**
    * 文章标题
    */
    private void setTitle(String title){
    this.title = title;
    }

    /**
    * 文章正文
    */
    private void setContent(String content){
    this.content = content;
    }

    /**
    * 文章摘要
    */
    private void setExcerpt(String excerpt){
    this.excerpt = excerpt;
    }

    /**
    * 封面图URL
    */
    private void setCoverImage(String coverImage){
    this.coverImage = coverImage;
    }

    /**
    * 文章状态，参照码表
    */
    private void setStatus(String status){
    this.status = status;
    }

    /**
    * 阅读量
    */
    private void setViews(Integer views){
    this.views = views;
    }

    /**
    * 创建时间
    */
    private void setCreatedAt(Date createdAt){
    this.createdAt = createdAt;
    }

    /**
    * 最后更新时间
    */
    private void setUpdatedAt(Date updatedAt){
    this.updatedAt = updatedAt;
    }


    /**
    * 文章ID
    */
    private String getId(){
    return this.id;
    }

    /**
    * 作者ID，关联 users.id
    */
    private String getAuthorId(){
    return this.authorId;
    }

    /**
    * 文章标题
    */
    private String getTitle(){
    return this.title;
    }

    /**
    * 文章正文
    */
    private String getContent(){
    return this.content;
    }

    /**
    * 文章摘要
    */
    private String getExcerpt(){
    return this.excerpt;
    }

    /**
    * 封面图URL
    */
    private String getCoverImage(){
    return this.coverImage;
    }

    /**
    * 文章状态，参照码表
    */
    private String getStatus(){
    return this.status;
    }

    /**
    * 阅读量
    */
    private Integer getViews(){
    return this.views;
    }

    /**
    * 创建时间
    */
    private Date getCreatedAt(){
    return this.createdAt;
    }

    /**
    * 最后更新时间
    */
    private Date getUpdatedAt(){
    return this.updatedAt;
    }

}
