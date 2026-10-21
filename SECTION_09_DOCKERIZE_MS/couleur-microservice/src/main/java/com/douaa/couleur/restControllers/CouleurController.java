package com.douaa.couleur.restControllers;

import com.douaa.couleur.config.Configuration;
import com.douaa.couleur.dto.CouleurDto;
import com.douaa.couleur.service.CouleurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/couleurs")
@RequiredArgsConstructor
@RefreshScope
public class CouleurController {
    private final CouleurService couleurService;
    private final Configuration configuration;

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping("{code}")
    public ResponseEntity<CouleurDto> getCouleurByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(couleurService.getCouleurByCode(code), HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName() + " " + configuration.getEmail());
    }
}