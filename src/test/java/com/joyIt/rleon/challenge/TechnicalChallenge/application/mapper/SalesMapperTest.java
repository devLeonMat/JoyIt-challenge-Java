package com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper;

import com.joyIt.rleon.challenge.TechnicalChallenge.AppChallengeUtilsForTest;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.SalesRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.entity.Sales;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SalesMapperTest {

    private SalesMapper mapper;

    @Mock
    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        mapper = new SalesMapper(productMapper);
    }

    @Test
    void toDto_1() {
        Sales entity = AppChallengeUtilsForTest.createSales();
        SalesResponseDto expected = AppChallengeUtilsForTest.createSalesResponseDto();
        SalesResponseDto result = mapper.toDto(entity);
        //then
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(expected);
    }
    @Test
    void toDto_2() {
        Sales entity = AppChallengeUtilsForTest.createSales();
        StoreResponseApiDto dtoApi = AppChallengeUtilsForTest.createStoreResponseApiDto();
        ProductResponseDto responseDto = AppChallengeUtilsForTest.createProductResponseDto();
        when(productMapper.toDto(dtoApi)).thenReturn(responseDto);

        SalesResponseDto expected = AppChallengeUtilsForTest.createSalesResponseDtoWithDetails();
        SalesResponseDto result = mapper.toDto(entity, dtoApi);
        //then
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void toDto_3() {
        SalesRequestDto dto = AppChallengeUtilsForTest.createSalesRequestDto();
        Sales expected = AppChallengeUtilsForTest.createSales();

        Sales result = mapper.toEntity(dto);
        //then
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(expected);
    }

}
