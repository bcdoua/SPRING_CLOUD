package com.douaa.couleur.service;

import com.douaa.couleur.dto.CouleurDto;

public interface CouleurService {
    CouleurDto getCouleurByCode(String code);
}