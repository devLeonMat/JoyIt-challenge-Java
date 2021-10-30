package com.joyIt.rleon.challenge.TechnicalChallenge.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalesRequestDto {
    private Long salesId;
    private Long productId;
    public double price;
    public double iva;
    private Long idClient;
}
