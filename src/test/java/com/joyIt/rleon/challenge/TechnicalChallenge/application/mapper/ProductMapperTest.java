package com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper;

import com.joyIt.rleon.challenge.TechnicalChallenge.AppChallengeUtilsForTest;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.ProductRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.request.StoreRequestApiDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class ProductMapperTest {

    private ProductMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ProductMapper();
    }

    @Test
    void toDto_1() {
        StoreResponseApiDto entity = AppChallengeUtilsForTest.createStoreResponseApiDto();
        ProductResponseDto expected = AppChallengeUtilsForTest.createProductResponseDto();
        ProductResponseDto result = mapper.toDto(entity);
        //then
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void toDto_2() {
        ProductRequestDto dto = AppChallengeUtilsForTest.createProductRequestDto();
        StoreRequestApiDto expected = AppChallengeUtilsForTest.createStoreRequestApiDto();

        StoreRequestApiDto result = mapper.toDto(dto);
        //then
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(expected);
    }

}
