package com.joyIt.rleon.challenge.TechnicalChallenge.service.impl;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper.ProductMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception.custom.NotFoundException;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.StoreClientApi;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.request.StoreRequestApiDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {

    private final StoreClientApi storeClientApi;

    private final ProductMapper productMapper;

    @Override
    public List<ProductResponseDto> getProducts(Long limit) {
        if (isNull(limit)) {
            return storeClientApi.getProducts()
                    .stream()
                    .map(productMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            return storeClientApi.getProducts(limit)
                    .stream()
                    .map(productMapper::toDto)
                    .collect(Collectors.toList());
        }

    }

    @Override
    public ProductResponseDto getProductById(Long productId) {
        StoreResponseApiDto responseApiDto = storeClientApi.getProductById(productId);
        if (isNull(responseApiDto)) {
            throw new NotFoundException();
        }
        return productMapper.toDto(responseApiDto);
    }

    @Override
    public ProductResponseDto createProduct(StoreRequestApiDto storeRequestApiDto) {
        return productMapper.toDto(storeClientApi.createNewProduct(storeRequestApiDto));
    }
}
