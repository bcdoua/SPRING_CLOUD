package com.douaa.couleur.repos;

import com.douaa.couleur.entities.Couleur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleurRepository extends JpaRepository<Couleur, Long> {
    Couleur findByCouleurCode(String code);
}