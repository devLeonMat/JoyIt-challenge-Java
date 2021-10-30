package com.joyIt.rleon.challenge.TechnicalChallenge.service;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.request.StoreRequestApiDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getProducts(Long limit);

    ProductResponseDto getProductById(Long productId);

    ProductResponseDto createProduct(StoreRequestApiDto storeRequestApiDto);




}
