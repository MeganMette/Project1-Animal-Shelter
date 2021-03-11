package com.bae.shelter.service.shelter;

import java.util.List;

import com.bae.shelter.domain.ShelterAnimal;

public interface ShelterAnimalService {
	ShelterAnimal createShelterAnimal(ShelterAnimal shelterAnimal);

	List<ShelterAnimal> getShelterAnimal();

	ShelterAnimal getShelterAnimalById(Long animalId);

	boolean removeShelterAnimal(Long animalId);

	ShelterAnimal updateShelterAnimal(Long animalId, ShelterAnimal newShelterAnimal);

	ShelterAnimal getShelterAnimalByName(String Name);

	ShelterAnimal findByName(String name);

	boolean removeAnimalShelter(Long animalId);

	ShelterAnimal getShelterAnimalByType(String animalType);

}
