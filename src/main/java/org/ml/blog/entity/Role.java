package org.ml.blog.entity;

import java.io.Serializable;

import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

/**
* 角色表
* @TableName role
*/

@Entity

@Getter
@Setter
public class Role implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    @Schema(description = "主键")
    @Id
    @GeneratedValue
    @UuidGenerator
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


}
