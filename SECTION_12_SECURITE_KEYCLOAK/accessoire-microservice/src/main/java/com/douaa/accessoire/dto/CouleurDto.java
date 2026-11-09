package com.douaa.accessoire.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouleurDto {
    private Long id;
    private String couleurName;
    private String couleurCode;
}