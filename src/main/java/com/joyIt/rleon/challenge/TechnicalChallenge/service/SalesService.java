package com.joyIt.rleon.challenge.TechnicalChallenge.service;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.entity.Sales;

import java.util.List;

public interface SalesService {

    List<SalesResponseDto> getSales();

    SalesResponseDto getSale(Long idSale);

    SalesResponseDto createNewSales(Sales sales);


}
