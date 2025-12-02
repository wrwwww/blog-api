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
public class UserDTO implements Serializable {

    /**
     * 主键
     */
    @NotBlank(message = "[主键]不能为空")

    @Size(max = 36, message = "[主键]长度不能超过36")
    private String id;

    /**
     * 用户名
     */

    @Size(max = 10, message = "[用户名]长度不能超过10")
    private String username;

    /**
     * 邮箱
     */

    @Size(max = 100, message = "[邮箱]长度不能超过100")
    private String email;

    /**
     * 昵称
     */

    @Size(max = 50, message = "[昵称]长度不能超过50")
    private String nickname;

    /**
     * 密码哈希
     */
    @NotBlank(message = "[密码哈希]不能为空")

    @Size(max = 255, message = "[密码哈希]长度不能超过255")
    private String password;

    /**
     * 头像链接
     */

    @Size(max = 255, message = "[头像链接]长度不能超过255")
    private String avatar;

}
