package com.zoo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.model.AnimalPropertie;

public interface AnimalRepository extends JpaRepository<AnimalPropertie, Integer> {

}