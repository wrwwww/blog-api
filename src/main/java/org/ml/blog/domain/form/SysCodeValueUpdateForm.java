package org.ml.blog.domain.form;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
@Getter
@Setter
@NoArgsConstructor
public class SysCodeValueUpdateForm extends SysCodeValueForm {

    @NotNull(message = "[]不能为空")
    private String id;
}
