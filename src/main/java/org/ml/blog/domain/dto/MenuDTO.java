package org.ml.blog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MenuDTO implements Serializable {

    /**
     * 主键
     */
    @NotBlank(message = "[主键]不能为空")

    @Size(max = 36, message = "[主键]长度不能超过36")
    private String id;

    /**
     * 权限名
     */

    @Size(max = 10, message = "[权限名]长度不能超过10")
    private String menuName;

    /**
     * 权限类型
     */
    @NotNull(message = "[权限类型]不能为空")

    private Integer menuType;

    /**
     * 父节点id
     */

    private Long parentId;

    /**
     * 是否有父节点
     */
    @NotNull(message = "[是否有父节点]不能为空")

    private Integer isParent;
}
