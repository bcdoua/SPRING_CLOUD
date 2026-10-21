package com.douaa.accessoire.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessoireDto {
    private Long id;
    private String accessoireName;
    private String accessoireCode;
    private String couleurCode;
}