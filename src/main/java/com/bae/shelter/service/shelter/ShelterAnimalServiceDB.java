package com.bae.shelter.service.shelter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bae.shelter.domain.ShelterAnimal;
import com.bae.shelter.repo.ShelterAnimalRepo;

@Service
public class ShelterAnimalServiceDB implements ShelterAnimalService {

	private ShelterAnimalRepo repo;

	public ShelterAnimalServiceDB(ShelterAnimalRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public ShelterAnimal createShelterAnimal(ShelterAnimal shelterAnimal) {
		return this.repo.save(shelterAnimal);
	}

	@Override
	public List<ShelterAnimal> getShelterAnimal() {
		return this.repo.findAll();
	}

	@Override
	public ShelterAnimal getShelterAnimalById(Long animalId) {
		Optional<ShelterAnimal> optShelterAnimal = this.repo.findById(animalId);
		return optShelterAnimal.get();
	}

	@Override
	public ShelterAnimal getShelterAnimalByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public ShelterAnimal getShelterAnimalByType(String animalType) {
		return this.repo.findByAnimalType(animalType);
	}

	@Override
	public ShelterAnimal updateShelterAnimal(Long animalId, ShelterAnimal newShelteranimal) {

		Optional<ShelterAnimal> existingOptional = this.repo.findById(animalId);
		ShelterAnimal existing = existingOptional.get();

		existing.setAnimalType(newShelteranimal.getAnimalType());
		existing.setName(newShelteranimal.getName());
		existing.setAge(newShelteranimal.getAge());
		existing.setBreed(newShelteranimal.getBreed());
		existing.setGender(newShelteranimal.getGender());
		existing.setSize(newShelteranimal.getSize());
		existing.setLocation(newShelteranimal.getLocation());
		existing.setAdditionalInformation(newShelteranimal.getAdditionalInformation());

		return this.repo.save(existing);
	}

	@Override
	public boolean removeShelterAnimal(Long animalId) {
		this.repo.deleteById(animalId);
		System.out.println("HELLO");
		boolean exists = this.repo.existsById(animalId);
		return !exists;
	}

	@Override
	public ShelterAnimal findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
