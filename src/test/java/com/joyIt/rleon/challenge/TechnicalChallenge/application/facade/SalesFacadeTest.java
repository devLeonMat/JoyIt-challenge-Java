package com.joyIt.rleon.challenge.TechnicalChallenge.application.facade;

import com.joyIt.rleon.challenge.TechnicalChallenge.AppChallengeUtilsForTest;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.SalesRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper.SalesMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.entity.Sales;
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
    void getSalesTest() {
        List<SalesResponseDto> responseDtoList = AppChallengeUtilsForTest.createListSalesResponseDto(2);

        //when
        when(salesService.getSales()).thenReturn(responseDtoList);
        List<SalesResponseDto> result = underTest.getSales();
        //then
        verify(salesService, times(1)).getSales();
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(responseDtoList);
    }

    @Test
    void getSalesByIdTest() {
        SalesResponseDto responseDto = AppChallengeUtilsForTest.createSalesResponseDto();

        //when
        when(salesService.getSale(anyLong())).thenReturn(responseDto);
        SalesResponseDto result = underTest.getSaleById(1L);
        //then
        verify(salesService, times(1)).getSale(anyLong());
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(responseDto);
    }

    @Test
    void createSalesTest() {
        SalesResponseDto responseDto = AppChallengeUtilsForTest.createSalesResponseDto();
        SalesRequestDto requestDto = AppChallengeUtilsForTest.createSalesRequestDto();
        Sales requestApiDto = AppChallengeUtilsForTest.createSales();

        //when
        when(salesMapper.toEntity(any(SalesRequestDto.class))).thenReturn(requestApiDto);
        when(salesService.createNewSales(any())).thenReturn(responseDto);
        SalesResponseDto result = underTest.createSales(requestDto);
        //then
        verify(salesService, times(1)).createNewSales(any());
        assertThat(result).isNotNull().usingRecursiveComparison().isEqualTo(responseDto);
    }

}
