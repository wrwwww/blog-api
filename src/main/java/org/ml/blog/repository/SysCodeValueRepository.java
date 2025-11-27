package org.ml.blog.repository;

import org.ml.blog.domain.entity.SysCodeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysCodeValueRepository extends JpaRepository<SysCodeValue, Long> {
    List<SysCodeValue> findByCodeType(String codeType);

    SysCodeValue findByCodeValue(String codeValue);

    SysCodeValue findSysCodeValueById(String id);

    void deleteSysCodeValueById(String id);
}
