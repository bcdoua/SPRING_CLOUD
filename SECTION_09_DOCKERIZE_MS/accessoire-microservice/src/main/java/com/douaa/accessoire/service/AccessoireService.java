package com.douaa.accessoire.service;

import com.douaa.accessoire.dto.APIResponseDto;

public interface AccessoireService {
    APIResponseDto getAccessoireById(Long id);
}