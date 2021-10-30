package com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.ProductRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.request.StoreRequestApiDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDto toDto(StoreResponseApiDto storeResponseApiDto) {
        return ProductResponseDto.builder()
                .id(storeResponseApiDto.id)
                .title(storeResponseApiDto.title)
                .price(storeResponseApiDto.price)
                .category(storeResponseApiDto.category)
                .description(storeResponseApiDto.description)
                .image(storeResponseApiDto.image)
                .build();

    }

    public StoreRequestApiDto toDto(ProductRequestDto productRequestDto) {
        return StoreRequestApiDto.builder()
                .id(productRequestDto.id)
                .title(productRequestDto.title)
                .price(productRequestDto.price)
                .category(productRequestDto.category)
                .description(productRequestDto.description)
                .image(productRequestDto.image)
                .build();

    }


}
