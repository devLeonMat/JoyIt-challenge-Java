package com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.SalesRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.entity.Sales;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesMapper {

    private final ProductMapper productMapper;

    public SalesResponseDto toDto(Sales salesEntity) {
        return SalesResponseDto.builder()
                .salesId(salesEntity.getId())
                .price(salesEntity.getAmount())
                .iva(salesEntity.getIva())
                .idClient(salesEntity.getClientId())
                .productId(salesEntity.getProductId())
                .build();

    }

    public SalesResponseDto toDto(Sales salesEntity, StoreResponseApiDto responseApiDto) {
        return SalesResponseDto.builder()
                .salesId(salesEntity.getId())
                .price(salesEntity.getAmount())
                .iva(salesEntity.getIva())
                .idClient(salesEntity.getClientId())
                .productId(salesEntity.getProductId())
                .productDetail(productMapper.toDto(responseApiDto))
                .build();

    }


    public Sales toEntity(SalesRequestDto salesRequestDto) {
        return Sales.builder()
                .id(salesRequestDto.getSalesId())
                .amount(salesRequestDto.getPrice())
                .iva(salesRequestDto.iva)
                .clientId(salesRequestDto.getIdClient())
                .productId(salesRequestDto.getProductId())
                .build();

    }


}
