package com.douaa.accessoire.restControllers;

import com.douaa.accessoire.config.Configuration;
import com.douaa.accessoire.dto.APIResponseDto;
import com.douaa.accessoire.service.AccessoireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accessoires")
@RequiredArgsConstructor
public class AccessoireController {

    private final AccessoireService accessoireService;
    private final Configuration configuration;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getAccessoireById(@PathVariable("id") Long id) {
        return new ResponseEntity<APIResponseDto>(
                accessoireService.getAccessoireById(id), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName() + " " + configuration.getEmail());
    }
}