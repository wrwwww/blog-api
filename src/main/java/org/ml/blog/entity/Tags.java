package org.ml.blog.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;


/**
 * 标签表
 *
 * @TableName tags
 */
public class Tags implements Serializable {

    /**
     * 标签ID
     */
    @NotNull(message = "[标签ID]不能为空")
    @Schema(description="标签ID")
    private String id;
    /**
     * 标签名称
     */
    @NotBlank(message = "[标签名称]不能为空")
    @Size(max = 50, message = "编码长度不能超过50")
    @Schema(description = "标签名称")
    private String name;

    /**
     * 标签ID
     */
    private void setId(String id) {
        this.id = id;
    }

    /**
     * 标签名称
     */
    private void setName(String name) {
        this.name = name;
    }


    /**
     * 标签ID
     */
    private String getId() {
        return this.id;
    }

    /**
     * 标签名称
     */
    private String getName() {
        return this.name;
    }

}
