package com.joyIt.rleon.challenge.TechnicalChallenge.provider.store;

import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.request.StoreRequestApiDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "store-client", url = "${client.fake-store-ms}")
@Repository
public interface StoreClientApi {

    @PostMapping("/products")
    StoreResponseApiDto createNewProduct(StoreRequestApiDto storeRequestApiDto);

    @GetMapping("/products")
    List<StoreResponseApiDto> getProducts();

    @GetMapping("/products/{productId}")
    StoreResponseApiDto getProductById(@PathVariable(value = "productId") Long productId);

    @GetMapping("/products")
    List<StoreResponseApiDto> getProducts(@RequestParam("limit") Long limit);


}
