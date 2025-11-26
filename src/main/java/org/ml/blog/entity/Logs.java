package org.ml.blog.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

import java.util.Date;

/**
 * 系统日志表
 *
 * @TableName logs
 */
public class Logs implements Serializable {

    /**
     * 日志ID
     */
    @NotNull(message = "[日志ID]不能为空")
    @Schema(description = "日志ID")
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

    /**
     * 日志ID
     */
    private void setId(String id) {
        this.id = id;
    }

    /**
     * 操作用户ID，关联 users.id
     */
    private void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 操作内容
     */
    private void setAction(String action) {
        this.action = action;
    }

    /**
     * 操作IP
     */
    private void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 操作时间
     */
    private void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * 日志ID
     */
    private String getId() {
        return this.id;
    }

    /**
     * 操作用户ID，关联 users.id
     */
    private String getUserId() {
        return this.userId;
    }

    /**
     * 操作内容
     */
    private String getAction() {
        return this.action;
    }

    /**
     * 操作IP
     */
    private String getIp() {
        return this.ip;
    }

    /**
     * 操作时间
     */
    private Date getCreatedAt() {
        return this.createdAt;
    }

}
