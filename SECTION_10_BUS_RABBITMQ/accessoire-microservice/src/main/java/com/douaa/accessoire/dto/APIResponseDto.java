package com.douaa.accessoire.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private AccessoireDto accessoireDto;
    private CouleurDto couleurDto;
}