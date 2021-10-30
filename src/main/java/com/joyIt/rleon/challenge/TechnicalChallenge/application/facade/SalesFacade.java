package com.joyIt.rleon.challenge.TechnicalChallenge.application.facade;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request.SalesRequestDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper.SalesMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.service.SalesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesFacade {

    private final SalesService salesService;
    private final SalesMapper salesMapper;


    public List<SalesResponseDto> getSales() {
        return salesService.getSales();
    }


    public SalesResponseDto getSaleById(Long salesId) {
        return salesService.getSale(salesId);
    }

    public SalesResponseDto createSales(SalesRequestDto salesRequestDto) {
        return salesService.createNewSales(salesMapper.toEntity(salesRequestDto));
    }


}
