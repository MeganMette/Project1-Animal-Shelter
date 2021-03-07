package com.bae.shelter.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.shelter.domain.ShelterAnimal;
import com.bae.shelter.service.shelter.ShelterAnimalService;

@RestController
public class ShelterAnimalController {
	private ShelterAnimalService service;
	private Object shelterAnimal;

	public ShelterAnimalController(ShelterAnimalService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createShelter")
	public ResponseEntity<ShelterAnimal> createShelterAnimal(@RequestBody ShelterAnimal shelterAnimal) {
		this.shelterAnimal.add(shelterAnimal);
		ShelterAnimal added = this.shelterAnimal.get(this.shelterAnimal.size() - 1);
		return new ResponseEntity<ShelterAnimal>(added, HttpStatus.CREATED);
	}

	@GetMapping("/getShelterAnimal")
	public ResponseEntity<List<ShelterAnimal>> getShelterAnimal() {
		return ResponseEntity.ok(this.service.getShelterAnimal());
	}

	@GetMapping("/getShetlterAnimalById/{id}")
	public ShelterAnimal getShelterAnimalById(@PathVariable int animalId) {
		return this.service.getShelterAnimalById(animalId);
	}

	@GetMapping("/getShelterAnimalByName/{Name}")
	public ShelterAnimal getShelterAnimalByName(@PathVariable String Name) {
		return this.service.getShelterAnimalByName(Name);
	}

	@DeleteMapping("/removeShelterAnimal/{id}")
	public boolean removeShelterAnimal(@PathVariable int animalId) {
		return this.service.removeShelterAnimal(animalId);
	}

	@PutMapping("/updateShelterAnimal/{id}")
	public ShelterAnimal updateShelterAnimal(@PathVariable int animalId, @RequestBody ShelterAnimal newShelterAnimal) {
		return this.service.updateShelterAnimal(animalId, newShelterAnimal);
	}
}
