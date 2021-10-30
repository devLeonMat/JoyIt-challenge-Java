package com.joyIt.rleon.challenge.TechnicalChallenge.application.controller;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.SalesRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.facade.SalesFacade;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sales")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesController {

    private final SalesFacade salesFacade;

    @GetMapping()
    public ResponseEntity<List<SalesResponseDto>> getSales() {
        log.info("[SalesController:getSales]");
        return ResponseEntity.ok().body(salesFacade.getSales());
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SalesResponseDto> getSaleById(@NotNull @PathVariable(value = "saleId") Long saleId) {
        log.info("[SalesController:getSaleById]");
        return ResponseEntity.ok().body(salesFacade.getSaleById(saleId));
    }

    @PostMapping()
    public ResponseEntity<SalesResponseDto> createSales(@RequestBody SalesRequestDto salesRequestDto) {
        log.info("[SalesController:createSales]");
        return ResponseEntity.ok().body(salesFacade.createSales(salesRequestDto));
    }


}
