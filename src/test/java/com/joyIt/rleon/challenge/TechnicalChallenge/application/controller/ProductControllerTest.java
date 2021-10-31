package com.joyIt.rleon.challenge.TechnicalChallenge.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.AppChallengeUtilsForTest;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.ProductRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.facade.ProductFacade;
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

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    private ProductController productController;

    @MockBean
    private ProductFacade productFacade;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;


    @BeforeEach
    void setUp() {
        this.productController = new ProductController(productFacade);
    }


    @Test
    void itShouldGetProducts_200() throws Exception {
        List<ProductResponseDto> productResponseDtoList = AppChallengeUtilsForTest.createListProductResponseDto(2);

        //when
        when(productFacade.getProducts(any())).thenReturn(productResponseDtoList);
        mockMvc.perform(MockMvcRequestBuilders.get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void itShouldGetProductById_200() throws Exception {
        ProductResponseDto productResponseDto = AppChallengeUtilsForTest.createProductResponseDto();

        //when
        when(productFacade.getProductById(any())).thenReturn(productResponseDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/products/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void itShouldCreateProduct_200() throws Exception {
        ProductResponseDto productResponseDto = AppChallengeUtilsForTest.createProductResponseDto();
        ProductRequestDto productRequestDto = AppChallengeUtilsForTest.createProductRequestDto();

        //when
        when(productFacade.createProduct(any())).thenReturn(productResponseDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .content(mapper.writeValueAsString(productRequestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
