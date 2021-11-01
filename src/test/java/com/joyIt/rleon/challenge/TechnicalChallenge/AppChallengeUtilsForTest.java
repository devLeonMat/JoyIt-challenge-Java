package com.joyIt.rleon.challenge.TechnicalChallenge;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.ProductRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.SalesRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.entity.Sales;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.request.StoreRequestApiDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppChallengeUtilsForTest {


    public static ProductResponseDto createProductResponseDto() {
        return ProductResponseDto.builder()
                .id(1L)
                .title("title")
                .price("20.2")
                .category("category")
                .description("lorem ipsum set")
                .image("https://i.pravatar.cc")
                .build();
    }

    public static ProductRequestDto createProductRequestDto() {
        return ProductRequestDto.builder()
                .id(1L)
                .title("title")
                .price(20.2)
                .category("category")
                .description("lorem ipsum set")
                .image("https://i.pravatar.cc")
                .build();
    }

    public static List<ProductResponseDto> createListProductResponseDto(int quantity) {
        ArrayList<ProductResponseDto> productResponseDTOList = new ArrayList<>();
        int i = 0;
        do {
            ++i;
            productResponseDTOList.add(createProductResponseDto());
        } while (i <= quantity);

        return productResponseDTOList;
    }

    public static SalesResponseDto createSalesResponseDto() {
        return SalesResponseDto.builder()
                .salesId(1L)
                .productId(1L)
                .price(20.2)
                .idClient(1L)
                .iva(20.2)
                .build();
    }

    public static SalesResponseDto createSalesResponseDtoWithDetails() {
        return SalesResponseDto.builder()
                .salesId(1L)
                .productId(1L)
                .price(20.2)
                .idClient(1L)
                .iva(20.2)
                .productDetail(createProductResponseDto())
                .build();
    }

    public static SalesRequestDto createSalesRequestDto() {
        return SalesRequestDto.builder()
                .salesId(1L)
                .productId(1L)
                .price(20.2)
                .idClient(1L)
                .iva(20.2)
                .build();
    }

    public static List<SalesResponseDto> createListSalesResponseDto(int quantity) {
        ArrayList<SalesResponseDto> salesResponseDTOList = new ArrayList<>();
        int i = 0;
        do {
            ++i;
            salesResponseDTOList.add(createSalesResponseDto());
        } while (i <= quantity);

        return salesResponseDTOList;
    }

    public static StoreRequestApiDto createStoreRequestApiDto() {
        return StoreRequestApiDto.builder()
                .id(1L)
                .title("title")
                .price(20.2)
                .category("category")
                .description("lorem ipsum set")
                .image("https://i.pravatar.cc")
                .build();
    }

    public static Sales createSales() {
        return Sales.builder()
                .id(1L)
                .amount(20.2)
                .iva(20.2)
                .clientId(1L)
                .productId(1L)
                .build();
    }

    public static Optional<Sales> createSalesOptional() {
        return Optional.of(createSales());
    }

    public static StoreResponseApiDto createStoreResponseApiDto() {
        return StoreResponseApiDto.builder()
                .id(1L)
                .title("title")
                .price("20.2")
                .category("category")
                .description("lorem ipsum set")
                .image("https://i.pravatar.cc")
                .build();
    }

    public static List<StoreResponseApiDto> createListStoreResponseApiDto(int quantity) {
        ArrayList<StoreResponseApiDto> storeResponseApiDtoList = new ArrayList<>();
        int i = 0;
        do {
            ++i;
            storeResponseApiDtoList.add(createStoreResponseApiDto());
        } while (i <= quantity);

        return storeResponseApiDtoList;
    }

    public static List<Sales> createListSalesApiDto(int quantity) {
        ArrayList<Sales> salesApiDtoList = new ArrayList<>();
        int i = 0;
        do {
            ++i;
            salesApiDtoList.add(createSales());
        } while (i <= quantity);

        return salesApiDtoList;
    }


}
