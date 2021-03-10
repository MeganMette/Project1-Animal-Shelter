package com.bae.shelter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.shelter.domain.ShelterAnimal;

@Repository
public interface ShelterAnimalRepo extends JpaRepository<ShelterAnimal, Long> {

	ShelterAnimal findByName(String name);

}
