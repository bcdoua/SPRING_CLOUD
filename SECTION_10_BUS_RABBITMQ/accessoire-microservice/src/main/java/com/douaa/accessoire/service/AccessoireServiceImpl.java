package com.douaa.accessoire.service;

import com.douaa.accessoire.dto.APIResponseDto;
import com.douaa.accessoire.dto.AccessoireDto;
import com.douaa.accessoire.dto.CouleurDto;
import com.douaa.accessoire.entities.Accessoire;
import com.douaa.accessoire.repos.AccessoireRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccessoireServiceImpl implements AccessoireService {
    private AccessoireRepository accessoireRepository;
    private APIClient apiClient;

    @Override
    public APIResponseDto getAccessoireById(Long id) {
        Accessoire accessoire = accessoireRepository.findById(id).get();

        CouleurDto couleurDto = apiClient.getCouleurByCode(accessoire.getCouleurCode());

        AccessoireDto accessoireDto = new AccessoireDto(
                accessoire.getId(),
                accessoire.getAccessoireName(),
                accessoire.getAccessoireCode(),
                accessoire.getCouleurCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setAccessoireDto(accessoireDto);
        apiResponseDto.setCouleurDto(couleurDto);

        return apiResponseDto;
    }
}