package com.beyond.backend.data.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * <p>기본 Entity
 *
 * <p>packageName    : com.beyond.backend.data.entity
 * <p>fileName       : BaseEntity
 * <p>author         : hjsong
 * <p>date           : 2025-01-18
 * <p>description    : 기본 Entity
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-18        hjsong             최초 생성
 * 2025-01-20        hjsong             파일명 이니셜(_shj) 삭제
 * 2025-02-04        jaewoo             카멜케이스로 네이밍 변환
 */
@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

}