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
* 用户表
* @TableName user
*/
@Entity
@Getter
@NoArgsConstructor
@Setter
public class User implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @Schema(description="主键")
    @Id
    @GeneratedValue
    @UuidGenerator
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


}
