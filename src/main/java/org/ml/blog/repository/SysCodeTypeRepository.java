package org.ml.blog.repository;

import org.ml.blog.domain.entity.SysCodeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysCodeTypeRepository extends JpaRepository<SysCodeType, String> {
    SysCodeType findByCodeType(String codeType);

    SysCodeType findSysCodeTypeById(String id);

    boolean deleteSysCodeTypesByCodeType(String codeType);
}
