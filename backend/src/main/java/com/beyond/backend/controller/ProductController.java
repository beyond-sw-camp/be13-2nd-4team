package com.beyond.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.beyond.backend.data.dto.ChangeProductNameDto;
import com.beyond.backend.data.dto.ProductDto;
import com.beyond.backend.data.dto.ProductResponseDto;
import com.beyond.backend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>상품 API
 *
 * <p>packageName    : com.beyond.backend.controller
 * <p>fileName       : ProductController
 * <p>author         : hjsong
 * <p>date           : 2025-01-18
 * <p>description    : 상품 API
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-18        hjsong             최초 생성
 * 2025-01-20        hjsong             파일명 이니셜(_shj) 삭제
 */
@Tag(name = "상품 API", description = "상품 API")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Test 메서드
     *
     * @return the string
     */
    @Operation(summary = "test 메서드", description = "test 메서드입니다.")
    @GetMapping(value = "/test")
    public String getHello(){
        return "Hello World";
    }


    /**
     * Get product response entity.
     *
     * @param number the number
     * @return the response entity
     */
    @Operation(summary = "상품 조회 메서드", description = "상품 조회 메서드입니다.")
    @GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(Long number){
        ProductResponseDto productResponseDto = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @Operation(summary = "상품 등록 메서드", description = "상품 등록 메서드입니다.")
    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {

        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @Operation(summary = "상품 상품명 수정 메서드", description = "상품 상품명 수정 메서드입니다.")
    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(
            @RequestBody ChangeProductNameDto changeProductNameDto) throws Exception {

        ProductResponseDto productResponseDto = productService.changeProductName(
                changeProductNameDto.getNumber(),
                changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);

    }

    @Operation(summary = "상품 삭제 메서드", description = "상품 삭제 메서드입니다.")
    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}

