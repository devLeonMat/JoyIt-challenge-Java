package com.joyIt.rleon.challenge.TechnicalChallenge.application.facade;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.ProductRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper.ProductMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductFacade {

    private final ProductService productService;
    private final ProductMapper productMapper;


    public List<ProductResponseDto> getProducts(Long limit) {
        return productService.getProducts(limit);
    }

    public ProductResponseDto getProductById(Long productId) {
        return productService.getProductById(productId);
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        return productService.createProduct(productMapper.toDto(productRequestDto));
    }


}
