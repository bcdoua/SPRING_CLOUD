package com.douaa.accessoire.service;

import com.douaa.accessoire.dto.CouleurDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COULEUR")
public interface APIClient {
    @GetMapping("api/couleurs/{couleur-code}")
    CouleurDto getCouleurByCode(@PathVariable("couleur-code") String couleurCode);
}