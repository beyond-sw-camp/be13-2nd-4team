package com.beyond.backend.service;

import com.beyond.backend.data.dto.ProductDto;
import com.beyond.backend.data.dto.ProductResponseDto;

/**
 * <p>상품 Service
 *
 * <p>packageName    : com.beyond.backend.service.impl
 * <p>fileName       : ProductService
 * <p>author         : hjsong
 * <p>date           : 2025-01-18
 * <p>description    : 상품 Service
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-18        hjsong             최초 생성
 * 2025-01-20        hjsong             파일명 이니셜(_shj) 삭제
 */
public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto_);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}

