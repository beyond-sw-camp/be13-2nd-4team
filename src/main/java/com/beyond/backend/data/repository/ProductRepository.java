package com.beyond.backend.data.repository;

import com.beyond.backend.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>상품 Repository
 *
 * <p>packageName    : com.beyond.backend.data.repository
 * <p>fileName       : ProductRepository
 * <p>author         : hjsong
 * <p>date           : 2025-01-18
 * <p>description    : 상품 Repository
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-18        hjsong             최초 생성
 * 2025-01-20        hjsong             파일명 이니셜(_shj) 삭제
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
