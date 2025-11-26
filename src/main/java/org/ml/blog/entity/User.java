package org.ml.blog.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

import java.util.Date;

/**
* 用户表
* @TableName user
*/
public class User implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @Schema(description="主键")
    private String id;
    /**
    * 用户名
    */
    @Size(max= 10,message="编码长度不能超过10")
    @Schema(description="用户名")
    private String username;
    /**
    * 邮箱
    */
    @Size(max= 100,message="编码长度不能超过100")
    @Schema(description="邮箱")
    private String email;
    /**
    * 昵称
    */
    @Size(max= 50,message="编码长度不能超过50")
    @Schema(description="昵称")
    private String nickname;
    /**
    * 密码哈希
    */
    @NotBlank(message="[密码哈希]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @Schema(description="密码哈希")
    private String password;
    /**
    * 头像链接
    */
    @Size(max= 255,message="编码长度不能超过255")
    @Schema(description="头像链接")
    private String avatar;
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
    private void setId(String id){
    this.id = id;
    }

    /**
    * 用户名
    */
    private void setUsername(String username){
    this.username = username;
    }

    /**
    * 邮箱
    */
    private void setEmail(String email){
    this.email = email;
    }

    /**
    * 昵称
    */
    private void setNickname(String nickname){
    this.nickname = nickname;
    }

    /**
    * 密码哈希
    */
    private void setPassword(String password){
    this.password = password;
    }

    /**
    * 头像链接
    */
    private void setAvatar(String avatar){
    this.avatar = avatar;
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
    * 用户名
    */
    private String getUsername(){
    return this.username;
    }

    /**
    * 邮箱
    */
    private String getEmail(){
    return this.email;
    }

    /**
    * 昵称
    */
    private String getNickname(){
    return this.nickname;
    }

    /**
    * 密码哈希
    */
    private String getPassword(){
    return this.password;
    }

    /**
    * 头像链接
    */
    private String getAvatar(){
    return this.avatar;
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
