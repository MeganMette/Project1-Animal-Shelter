package com.bae.shelter.service.shelter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bae.shelter.domain.ShelterAnimal;
import com.bae.shelter.repo.ShelterAnimalRepo;

@Service
public class ShelterAnimalServiceDB {

	private ShelterAnimalRepo repo;

	public ShelterAnimalServiceDB(ShelterAnimalRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public ShelterAnimal createShelterAnimal(ShelterAnimal shelterAnimal) {
		ShelterAnimal saved = this.repo.save(shelterAnimal);
		return saved;
	}

	@Override
	public List<ShelterAnimal> getShelterAnimal() {
		return this.repo.findAll();
	}

	@Override
	public ShelterAnimal getShelterAnimalById(int animalId) {
		Optional<ShelterAnimal> optShelterAnimal = this.repo.fndById(animalId);
		return optShelterAnimal.get();
	}

	@Override
	public ShelterAnimal getShelterAnimalByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public boolean removeAnimalShelter(int animalId) {
		this.repo.deleteById(animalId);
		return !this.repo.existsById(animalId);
	}

	@Override
	public ShelterAnimal updateShelterAnimal(int animalId, ShelterAnimal newShelteranimal) {
		Optional<ShelterAnimal> optionalShelterAnimal = this.repo.findById(animalId);
		ShelterAnimal existing = optionalShelterAnimal.get();

		existing.setAnimalType(newShelteranimal.getAnimalType());
		existing.setName(newShelteranimal.getName());
		existing.setAge(newShelteranimal.getAge());
		existing.setBreed(newShelteranimal.getBreed());
		existing.setGender(newShelteranimal.getGender());
		existing.setSize(newShelteranimal.getSize());
		existing.setLocation(newShelteranimal.getLocation());
		existing.setAdditionalInformation(newShelteranimal.getAdditionalInformation());

		ShelterAnimal updated = this.repo.save(existing);
		return updated;

	}
}
