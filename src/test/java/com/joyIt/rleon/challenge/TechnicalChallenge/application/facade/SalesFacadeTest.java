package com.joyIt.rleon.challenge.TechnicalChallenge.application.facade;

import com.joyIt.rleon.challenge.TechnicalChallenge.AppChallengeUtilsForTest;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.ProductRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper.ProductMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper.SalesMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.request.StoreRequestApiDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.service.ProductService;
import com.joyIt.rleon.challenge.TechnicalChallenge.service.SalesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SalesFacadeTest {

    //Class to be tested
    private SalesFacade underTest;

    //Mocked
    @Mock
    private SalesService salesService;

    @Mock
    private SalesMapper salesMapper;

    @BeforeEach
    void setUp() {
        this.underTest = new SalesFacade(salesService, salesMapper);
    }


    @Test
    void getProductsTest() {
        List<ProductResponseDto> responseDtoList = AppChallengeUtilsForTest.createListProductResponseDto(2);

        //when
        when(productService.getProducts(anyLong())).thenReturn(responseDtoList);
        List<ProductResponseDto> result = underTest.getProducts(1L);
        //then
        verify(productService, times(1)).getProducts(anyLong());
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(responseDtoList);
    }

    @Test
    void getProductByIdTest() {
        ProductResponseDto responseDto = AppChallengeUtilsForTest.createProductResponseDto();

        //when
        when(productService.getProductById(anyLong())).thenReturn(responseDto);
        ProductResponseDto result = underTest.getProductById(1L);
        //then
        verify(productService, times(1)).getProductById(anyLong());
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(responseDto);
    }

    @Test
    void createProductTest() {
        ProductResponseDto responseDto = AppChallengeUtilsForTest.createProductResponseDto();
        ProductRequestDto requestDto = AppChallengeUtilsForTest.createProductRequestDto();
        StoreRequestApiDto requestApiDto = AppChallengeUtilsForTest.createStoreRequestApiDto();

        //when
        when(productMapper.toDto(any(ProductRequestDto.class))).thenReturn(requestApiDto);
        when(productService.createProduct(any())).thenReturn(responseDto);
        ProductResponseDto result = underTest.createProduct(requestDto);
        //then
        verify(productService, times(1)).createProduct(any());
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(responseDto);
    }

}
