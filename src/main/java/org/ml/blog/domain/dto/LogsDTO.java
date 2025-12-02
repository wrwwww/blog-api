package org.ml.blog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LogsDTO implements Serializable {

    /**
     * 日志ID
     */
    @NotBlank(message = "[日志ID]不能为空")

    @Size(max = 36, message = "[日志ID]长度不能超过36")
    private String id;

    /**
     * 操作用户ID，关联 users.id
     */

    @Size(max = 36, message = "[操作用户ID，关联 users.id]长度不能超过36")
    private String userId;

    /**
     * 操作内容
     */
    @NotBlank(message = "[操作内容]不能为空")

    @Size(max = 255, message = "[操作内容]长度不能超过255")
    private String action;

    /**
     * 操作IP
     */

    @Size(max = 50, message = "[操作IP]长度不能超过50")
    private String ip;

    /**
     * 操作时间
     */

    private LocalDateTime createdAt;
}
