package com.joyIt.rleon.challenge.TechnicalChallenge.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.AppChallengeUtilsForTest;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.SalesRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.facade.SalesFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SalesController.class)
public class SalesControllerTest {

    private SalesController salesController;

    @MockBean
    private SalesFacade salesFacade;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;


    @BeforeEach
    void setUp() {
        this.salesController = new SalesController(salesFacade);
    }


    @Test
    void itShouldGetSales_200() throws Exception {
        List<SalesResponseDto> salesResponseDtoList = AppChallengeUtilsForTest.createListSalesResponseDto(2);

        //when
        when(salesFacade.getSales()).thenReturn(salesResponseDtoList);
        mockMvc.perform(MockMvcRequestBuilders.get("/sales")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void itShouldGetSalesById_200() throws Exception {
        SalesResponseDto salesResponseDto = AppChallengeUtilsForTest.createSalesResponseDto();

        //when
        when(salesFacade.getSaleById(any())).thenReturn(salesResponseDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/sales/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void itShouldCreateSales_200() throws Exception {
        SalesResponseDto salesResponseDto = AppChallengeUtilsForTest.createSalesResponseDto();
        SalesRequestDto salesRequestDto = AppChallengeUtilsForTest.createSalesRequestDto();

        //when
        when(salesFacade.createSales(any())).thenReturn(salesResponseDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/sales")
                        .content(mapper.writeValueAsString(salesRequestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
