package com.douaa.accessoire.service;

import com.douaa.accessoire.dto.APIResponseDto;
import com.douaa.accessoire.dto.AccessoireDto;
import com.douaa.accessoire.dto.AccessoireMessageDto;
import com.douaa.accessoire.dto.CouleurDto;
import com.douaa.accessoire.entities.Accessoire;
import com.douaa.accessoire.exceptions.ResourceNotFoundException;
import com.douaa.accessoire.repos.AccessoireRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccessoireServiceImpl implements AccessoireService {

    private static final Logger log = LoggerFactory.getLogger(AccessoireServiceImpl.class);

    private AccessoireRepository accessoireRepository;
    private APIClient apiClient;
    private StreamBridge streamBridge;

    @Override
    public APIResponseDto getAccessoireById(Long id) {
        Accessoire accessoire = accessoireRepository.findById(id).get();

        CouleurDto couleurDto = apiClient.getCouleurByCode(accessoire.getCouleurCode());

        String cname;
        if (couleurDto == null)
            cname = "NOT AVAILABLE";
        else
            cname = couleurDto.getCouleurName();

        AccessoireDto accessoireDto = new AccessoireDto(
                accessoire.getId(),
                accessoire.getAccessoireName(),
                accessoire.getAccessoireCode(),
                accessoire.getCouleurCode(),
                cname,
                accessoire.getFournisseurEmail(),
                accessoire.getFournisseurMobile()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setAccessoireDto(accessoireDto);
        apiResponseDto.setCouleurDto(couleurDto);

        return apiResponseDto;
    }

    @Override
    public void createAccessoire(AccessoireDto accessoireDto) {
        Accessoire savedAccessoire = accessoireRepository.save(Accessoire.builder()
                .accessoireName(accessoireDto.getAccessoireName())
                .accessoireCode(accessoireDto.getAccessoireCode())
                .couleurCode(accessoireDto.getCouleurCode())
                .fournisseurEmail(accessoireDto.getFournisseurEmail())
                .fournisseurMobile(accessoireDto.getFournisseurMobile())
                .build());
        sendCommunication(savedAccessoire);
    }

    private void sendCommunication(Accessoire accessoire) {
        var accessoireMsgDto = new AccessoireMessageDto(
                accessoire.getId(),
                accessoire.getFournisseurEmail(),
                accessoire.getFournisseurMobile());
        log.info("Sending Communication request for the details: {}", accessoireMsgDto);
        var result = streamBridge.send("sendCommunication-out-0", accessoireMsgDto);
        log.info("Is the Communication request successfully triggered ? : {}", result);
    }
    @Override
    public boolean updateCommunicationStatus(Long accessoireId) {
        boolean isUpdated = false;
        if (accessoireId != null) {
            Accessoire accessoire = accessoireRepository.findById(accessoireId).orElseThrow(
                    () -> new ResourceNotFoundException("Accessoire", "AccessoireId", accessoireId.toString())
            );
            accessoire.setCommunicationDone(true);
            accessoireRepository.save(accessoire);
            isUpdated = true;
        }
        return isUpdated;
    }
}