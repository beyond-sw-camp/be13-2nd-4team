package com.beyond.backend.data.entity;

import com.beyond.backend.data.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>상품 Entity
 *
 * <p>packageName    : com.beyond.backend.data.entity
 * <p>fileName       : Product
 * <p>author         : hjsong
 * <p>date           : 2025-01-18
 * <p>description    : 상품 Entity
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-18        hjsong             최초 생성
 * 2025-01-20        hjsong             파일명 이니셜(_shj) 삭제
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    private Integer price;

    private Integer stock;
}

