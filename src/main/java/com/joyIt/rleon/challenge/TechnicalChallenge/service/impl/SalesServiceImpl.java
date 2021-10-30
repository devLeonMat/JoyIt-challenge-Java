package com.joyIt.rleon.challenge.TechnicalChallenge.service.impl;

import com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.response.SalesResponseDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.application.mapper.SalesMapper;
import com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception.custom.NotFoundException;
import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.entity.Sales;
import com.joyIt.rleon.challenge.TechnicalChallenge.persistence.repository.SalesRepository;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.StoreClientApi;
import com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response.StoreResponseApiDto;
import com.joyIt.rleon.challenge.TechnicalChallenge.service.SalesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesServiceImpl implements SalesService {

    private SalesRepository salesRepository;
    private final StoreClientApi storeClientApi;
    private final SalesMapper salesMapper;


    @Override
    public List<SalesResponseDto> getSales() {
        return salesRepository.findAll()
                .stream()
                .map(salesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SalesResponseDto getSale(Long idSale) {
        Sales sales = salesRepository.findById(idSale).orElseThrow(NotFoundException::new);
        StoreResponseApiDto storeResponseApiDto = storeClientApi.getProductById(sales.getProductId());
        return salesMapper.toDto(sales, storeResponseApiDto);
    }

    @Override
    public SalesResponseDto createNewSales(Sales sales) {
        return salesMapper.toDto(salesRepository.save(sales));
    }
}
