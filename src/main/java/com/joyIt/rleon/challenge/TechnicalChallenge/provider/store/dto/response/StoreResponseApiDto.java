package com.joyIt.rleon.challenge.TechnicalChallenge.provider.store.dto.response;

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
public class StoreResponseApiDto {
    public Long id;
    public String title;
    public String price;
    public String category;
    public String description;
    public String image;
}
