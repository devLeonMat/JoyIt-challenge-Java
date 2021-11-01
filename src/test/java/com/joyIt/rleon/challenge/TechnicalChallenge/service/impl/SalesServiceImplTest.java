package com.joyIt.rleon.challenge.TechnicalChallenge.service.impl;

import com.joyIt.rleon.challenge.TechnicalChallenge.AppChallengeUtilsForTest;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper.SalesMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.entity.Sales;
import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.repository.SalesRepository;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.StoreClientApi;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SalesServiceImplTest {

    @InjectMocks
    private SalesServiceImpl underTest;

    @Mock
    private SalesRepository repository;

    @Mock
    private StoreClientApi storeClientApi;

    @Mock
    private SalesMapper salesMapper;

    @Test
    void getSalesTest_OK() {
        List<Sales> salesList = AppChallengeUtilsForTest.createListSalesApiDto(2);
        SalesResponseDto responseDto = AppChallengeUtilsForTest.createSalesResponseDto();
        //when
        when(salesMapper.toDto(any(Sales.class))).thenReturn(responseDto);
        when(repository.findAll()).thenReturn(salesList);
        List<SalesResponseDto> result = underTest.getSales();
        assertThat(result).isNotNull();
    }

    @Test
    void getSaleTest_OK() {
        Optional<Sales> optionalSales = AppChallengeUtilsForTest.createSalesOptional();
        SalesResponseDto responseDto = AppChallengeUtilsForTest.createSalesResponseDto();
        StoreResponseApiDto responseApiDto = AppChallengeUtilsForTest.createStoreResponseApiDto();
        //when
        when(salesMapper.toDto(any(Sales.class), any(StoreResponseApiDto.class))).thenReturn(responseDto);
        when(repository.findById(anyLong())).thenReturn(optionalSales);
        when(storeClientApi.getProductById(anyLong())).thenReturn(responseApiDto);
        SalesResponseDto result = underTest.getSale(1L);
        assertThat(result).isNotNull();
    }

    @Test
    void createNewSales_OK() {
        Sales salesEntity = AppChallengeUtilsForTest.createSales();
        SalesResponseDto responseDto = AppChallengeUtilsForTest.createSalesResponseDto();
        //when
        when(salesMapper.toDto(any(Sales.class))).thenReturn(responseDto);
        when(repository.save(any())).thenReturn(salesEntity);
        SalesResponseDto result = underTest.createNewSales(any());
        assertThat(result).isNotNull();
    }
}
