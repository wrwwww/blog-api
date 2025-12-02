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
public class ArticlesDTO implements Serializable {

    /**
     * 文章ID
     */
    @NotBlank(message = "[文章ID]不能为空")

    @Size(max = 36, message = "[文章ID]长度不能超过36")
    private String id;

    /**
     * 作者ID，关联 users.id
     */
    @NotBlank(message = "[作者ID，关联 users.id]不能为空")

    @Size(max = 36, message = "[作者ID，关联 users.id]长度不能超过36")
    private String authorId;

    /**
     * 文章标题
     */
    @NotBlank(message = "[文章标题]不能为空")

    @Size(max = 255, message = "[文章标题]长度不能超过255")
    private String title;

    /**
     * 文章正文
     */

    @Size(max = 65535, message = "[文章正文]长度不能超过65,535")
    private String content;

    /**
     * 文章摘要
     */

    @Size(max = 65535, message = "[文章摘要]长度不能超过65,535")
    private String excerpt;

    /**
     * 封面图URL
     */

    @Size(max = 255, message = "[封面图URL]长度不能超过255")
    private String coverImage;

    /**
     * 文章状态，参照码表
     */

    @Size(max = 50, message = "[文章状态，参照码表]长度不能超过50")
    private String status;

    /**
     * 阅读量
     */

    private Integer views;


}
