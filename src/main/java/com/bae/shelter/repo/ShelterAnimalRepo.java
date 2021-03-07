package com.bae.shelter.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.shelter.domain.ShelterAnimal;

@Repository
public interface ShelterAnimalRepo extends JpaRepository<ShelterAnimal, int> {
	
	ShelterAnimal findByName(String name);

	ShelterAnimal save(ShelterAnimal shelterAnimal);

	List<ShelterAnimal> findAll();

	boolean existsById(int animalId);

	void deleteById(int animalId);

	Optional<ShelterAnimal> findById(int animalId);
}
