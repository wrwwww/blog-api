package org.ml.blog.repository;

import org.ml.blog.entity.SysCodeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysCodeTypeRepository extends JpaRepository<SysCodeType,String> {
    SysCodeType findByCodeType(String codeType);
}
