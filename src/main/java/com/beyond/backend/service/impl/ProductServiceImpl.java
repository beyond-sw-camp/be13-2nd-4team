package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.ProductDto;
import com.beyond.backend.data.dto.ProductResponseDto;
import com.beyond.backend.data.entity.Product;
import com.beyond.backend.data.repository.ProductRepository;
import com.beyond.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>상품 ServiceImpl
 *
 * <p>packageName    : com.beyond.backend.service.impl
 * <p>fileName       : ProductServiceImpl
 * <p>author         : hjsong
 * <p>date           : 2025-01-18
 * <p>description    : 상품 ServiceImpl
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-18        hjsong             최초 생성
 * 2025-01-20        hjsong             파일명 이니셜(_shj) 삭제
 * 2025-01-23        hjsong             로깅 삭제
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    /**
     * ProductServiceImpl 생성자
     * @param productRepository 상품 Repository
     * @see ProductRepository
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 상품 조회
     * @param number 상품 ID
     * @return ProductResponseDto productResponseDto
     * @see ProductResponseDto
     */
    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productRepository.findById(number).get();

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    /**
     * 상품 등록
     * @param productDto 상품 정보
     * @return ProductResponseDto productResponseDto
     * @see ProductResponseDto
     */
    @Override
    public ProductResponseDto saveProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        Product savedProduct = productRepository.save(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(savedProduct.getNumber());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());

        return productResponseDto;
    };

    /**
     * 상품명 변경
     * @param number 상품 ID
     * @param name 상품명
     * @return ProductResponseDto productResponseDto
     * @see ProductResponseDto
     * @throws Exception
     */
    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        Product changedProduct = productRepository.save(foundProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());

        return productResponseDto;
    }

    /**
     * 상품 삭제
     * @param number 상품 ID
     * @throws Exception
     */
    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
    }
}
