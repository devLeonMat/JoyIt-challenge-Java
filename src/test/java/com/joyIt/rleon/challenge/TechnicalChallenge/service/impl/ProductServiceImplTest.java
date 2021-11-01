package com.joyIt.rleon.challenge.TechnicalChallenge.service.impl;

import com.joyIt.rleon.challenge.TechnicalChallenge.AppChallengeUtilsForTest;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper.ProductMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception.custom.NotFoundException;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.StoreClientApi;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl underTest;

    @Mock
    private StoreClientApi storeClientApi;

    @Mock
    private ProductMapper productMapper;

    @Test
    void getProductsTest_OK() {
        List<StoreResponseApiDto> responseApiDtoList = AppChallengeUtilsForTest.createListStoreResponseApiDto(2);
        ProductResponseDto responseApiDto = AppChallengeUtilsForTest.createProductResponseDto();
        //when
        when(productMapper.toDto(any(StoreResponseApiDto.class))).thenReturn(responseApiDto);
        when(storeClientApi.getProducts(anyLong())).thenReturn(responseApiDtoList);
        List<ProductResponseDto> result = underTest.getProducts(5L);
        assertThat(result).isNotNull();
    }

    @Test
    void getProductsTest_OKv2() {
        List<StoreResponseApiDto> responseApiDtoList = AppChallengeUtilsForTest.createListStoreResponseApiDto(2);
        ProductResponseDto responseApiDto = AppChallengeUtilsForTest.createProductResponseDto();
        //when
        when(productMapper.toDto(any(StoreResponseApiDto.class))).thenReturn(responseApiDto);
        when(storeClientApi.getProducts()).thenReturn(responseApiDtoList);
        List<ProductResponseDto> result = underTest.getProducts(null);
        assertThat(result).isNotNull();
    }

    @Test
    void getProductByIdTest_OK() {
        StoreResponseApiDto responseApiDto = AppChallengeUtilsForTest.createStoreResponseApiDto();
        ProductResponseDto expected = AppChallengeUtilsForTest.createProductResponseDto();
        //when
        when(productMapper.toDto(any(StoreResponseApiDto.class))).thenReturn(expected);
        when(storeClientApi.getProductById(anyLong())).thenReturn(responseApiDto);
        ProductResponseDto result = underTest.getProductById(anyLong());
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void getProductByIdTest_NotFoundException() {
        //when
        when(storeClientApi.getProductById(anyLong())).thenReturn(null);
        assertThatThrownBy(() -> underTest.getProductById(anyLong())).isInstanceOf(NotFoundException.class);
    }

    @Test
    void createProduct_OK() {
        StoreResponseApiDto responseApiDto = AppChallengeUtilsForTest.createStoreResponseApiDto();
        ProductResponseDto expected = AppChallengeUtilsForTest.createProductResponseDto();
        //when
        when(productMapper.toDto(any(StoreResponseApiDto.class))).thenReturn(expected);
        when(storeClientApi.createNewProduct(any())).thenReturn(responseApiDto);
        ProductResponseDto result = underTest.createProduct(any());
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(expected);
    }
}
