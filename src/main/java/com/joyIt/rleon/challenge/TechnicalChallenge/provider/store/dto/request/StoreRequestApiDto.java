package com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.request;

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
public class StoreRequestApiDto {
    public Long id;
    public String title;
    public double price;
    public String description;
    public String image;
    public String category;
}
