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
public class RoleDTO implements Serializable {

    /**
     * 主键
     */
    @NotBlank(message = "[主键]不能为空")
    @Size(max = 36, message = "[主键]长度不能超过36")
    private String id;

    /**
     * 角色名
     */

    @Size(max = 10, message = "[角色名]长度不能超过10")
    private String roleName;

}
