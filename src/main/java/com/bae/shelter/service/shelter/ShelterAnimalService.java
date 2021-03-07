package com.bae.shelter.service.shelter;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.bae.shelter.domain.ShelterAnimal;

public interface ShelterAnimalService {
	HttpStatus createShelterAnimal(ShelterAnimal shelterAnimal);

	List<ShelterAnimal> getShelterAnimal();

	ShelterAnimal getShelterAnimalById(int animalId);

	boolean removeShelterAnimal(int animalId);

	ShelterAnimal updateShelterAnimal(int animalId, ShelterAnimal newShelterAnimal);

	ShelterAnimal getShelterAnimalByName(String Name);
}
