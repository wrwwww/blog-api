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


/**
 * 标签表
 *
 * @TableName tags
 */

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Tags implements Serializable {

    /**
     * 标签ID
     */
    @NotNull(message = "[标签ID]不能为空")
    @Schema(description = "标签ID")
    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;
    /**
     * 标签名称
     */
    @NotBlank(message = "[标签名称]不能为空")
    @Size(max = 50, message = "编码长度不能超过50")
    @Schema(description = "标签名称")
    private String name;


}
