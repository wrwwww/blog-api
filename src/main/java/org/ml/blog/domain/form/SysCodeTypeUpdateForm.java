package org.ml.blog.domain.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 码表类型表
 *
 * @TableName sys_code_type
 */
@Getter
@NoArgsConstructor
@Setter
public class SysCodeTypeUpdateForm extends SysCodeTypeForm{



    @NotNull(message = "[]不能为空")
    private String id;

}
