package com.douaa.accessoire.service;

import com.douaa.accessoire.dto.APIResponseDto;
import com.douaa.accessoire.dto.AccessoireDto;

public interface AccessoireService {
    APIResponseDto getAccessoireById(Long id);

    void createAccessoire(AccessoireDto accessoireDto);

    boolean updateCommunicationStatus(Long accessoireId);
}