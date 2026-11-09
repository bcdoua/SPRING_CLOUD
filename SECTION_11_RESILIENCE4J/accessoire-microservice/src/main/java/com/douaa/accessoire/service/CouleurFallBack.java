package com.douaa.accessoire.service;

import com.douaa.accessoire.dto.CouleurDto;
import org.springframework.stereotype.Component;

@Component
public class CouleurFallBack implements APIClient {

    @Override
    public CouleurDto getCouleurByCode(String couleurCode) {
        return null;
    }
}