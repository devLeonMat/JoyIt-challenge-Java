package com.joyIt.rleon.challenge.TechnicalChallenge.application.controller;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.ProductRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.ProductResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.facade.ProductFacade;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductFacade productFacade;

    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getProducts(@RequestParam(value = "limit", required = false) Long limit) {
        log.info("[ProductController:getProducts]");
        return ResponseEntity.ok().body(productFacade.getProducts(limit));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@NotNull @PathVariable(value = "productId") Long productId) {
        log.info("[ProductController:getProductById]");
        return ResponseEntity.ok().body(productFacade.getProductById(productId));
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        log.info("[ProductController:createProduct]");
        return ResponseEntity.ok().body(productFacade.createProduct(productRequestDto));
    }


}
