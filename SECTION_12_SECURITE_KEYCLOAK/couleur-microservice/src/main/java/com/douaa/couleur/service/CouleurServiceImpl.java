package com.douaa.couleur.service;

import com.douaa.couleur.dto.CouleurDto;
import com.douaa.couleur.entities.Couleur;
import com.douaa.couleur.repos.CouleurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouleurServiceImpl implements CouleurService {
    @Autowired
    CouleurRepository couleurRepository;

    @Override
    public CouleurDto getCouleurByCode(String code) {
        Couleur couleur = couleurRepository.findByCouleurCode(code);
        CouleurDto couleurDto = new CouleurDto(
                couleur.getId(),
                couleur.getCouleurName(),
                couleur.getCouleurCode()
        );
        return couleurDto;
    }
}