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
		ShelterAnimal saved = this.repo.save(shelterAnimal);
		return saved;
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
	public boolean removeAnimalShelter(Long animalId) {
		this.repo.deleteById(animalId);
		boolean exists = this.repo.existsById(animalId);
		return !exists;
	}

	@Override
	public ShelterAnimal updateShelterAnimal(Long animalId, ShelterAnimal newShelteranimal) {
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

	@Override
	public boolean removeShelterAnimal(Long animalId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ShelterAnimal findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
