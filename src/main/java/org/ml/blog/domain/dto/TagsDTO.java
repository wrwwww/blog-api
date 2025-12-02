package org.ml.blog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TagsDTO implements Serializable {

    /**
     * 标签ID
     */
    @NotBlank(message = "[标签ID]不能为空")

    @Size(max = 36, message = "[标签ID]长度不能超过36")
    private String id;

    /**
     * 标签名称
     */
    @NotBlank(message = "[标签名称]不能为空")

    @Size(max = 50, message = "[标签名称]长度不能超过50")
    private String name;
}
