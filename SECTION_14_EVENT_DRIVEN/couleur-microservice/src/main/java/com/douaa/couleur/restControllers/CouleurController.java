package com.douaa.couleur.restControllers;

import com.douaa.couleur.dto.CouleurDto;
import com.douaa.couleur.service.CouleurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/couleurs")
@RequiredArgsConstructor
public class CouleurController {
    private final CouleurService couleurService;

    @GetMapping("{code}")
    public ResponseEntity<CouleurDto> getCouleurByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(couleurService.getCouleurByCode(code), HttpStatus.OK);
    }
}