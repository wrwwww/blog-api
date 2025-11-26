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
 * 系统日志表
 *
 * @TableName logs
 */

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Logs implements Serializable {

    /**
     * 日志ID
     */
    @NotNull(message = "[日志ID]不能为空")
    @Schema(description = "日志ID")
    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;
    /**
     * 操作用户ID，关联 users.id
     */
    @Schema(description="操作用户ID，关联 users.id")
    private String userId;
    /**
     * 操作内容
     */
    @NotBlank(message = "[操作内容]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @Schema(description="操作内容")
    private String action;
    /**
     * 操作IP
     */
    @Size(max = 50, message = "编码长度不能超过50")
    @Schema(description="操作IP")

    private String ip;
    /**
     * 操作时间
     */
    @Schema(description="操作时间")
    private Date createdAt;



}
