package com.douaa.accessoire.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.douaa.accessoire.entities.Accessoire;

public interface AccessoireRepository extends JpaRepository<Accessoire, Long> {
}