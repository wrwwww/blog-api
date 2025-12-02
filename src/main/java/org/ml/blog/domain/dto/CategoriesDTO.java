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
public class CategoriesDTO implements Serializable {

    /**
     * 分类ID
     */
    @NotBlank(message = "[分类ID]不能为空")
    @Size(max = 36, message = "[分类ID]长度不能超过36")
    private String id;

    /**
     * 分类名称
     */
    @NotBlank(message = "[分类名称]不能为空")

    @Size(max = 50, message = "[分类名称]长度不能超过50")
    private String name;

    /**
     * 父分类ID，自关联 categories.id
     */

    @Size(max = 36, message = "[父分类ID，自关联 categories.id]长度不能超过36")
    private String parentId;

}
