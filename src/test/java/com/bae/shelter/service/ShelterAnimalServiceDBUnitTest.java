package com.bae.shelter.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.bae.shelter.domain.ShelterAnimal;
import com.bae.shelter.repo.ShelterAnimalRepo;
import com.bae.shelter.service.shelter.ShelterAnimalServiceDB;

@SpringBootTest
@ActiveProfiles("test")
public class ShelterAnimalServiceDBUnitTest {

	@Autowired
	private ShelterAnimalServiceDB service;

	@MockBean
	private ShelterAnimalRepo repo;

	@Test
	void testCreate() {
		ShelterAnimal newShelterAnimal = new ShelterAnimal(null, "Dog", "Archie", 4, "Cockapoo", "Male", "Medium",
				"East Riding of Yorkshire", "no additional information", null);

		ShelterAnimal savedShelterAnimal = new ShelterAnimal(1L, "Dog", "Archie", 4, "Cockapoo", "Male", "Medium",
				"East Riding of Yorkshire", "no additional information", null);

		Mockito.when(this.repo.save(newShelterAnimal)).thenReturn(savedShelterAnimal);

		assertThat(this.service.createShelterAnimal(newShelterAnimal)).isEqualTo(savedShelterAnimal);

		Mockito.verify(this.repo, Mockito.times(1)).save(newShelterAnimal);
	}

	@Test
	void testUpdate() {

		Long animalId = 1L;

		ShelterAnimal newShelterAnimal = new ShelterAnimal(animalId, "Dog", "Archie", 4, "Cockapoo", "Male", "Medium",
				"East Riding of Yorkshire", "no additional information", null);

		Optional<ShelterAnimal> optionalShelterAnimal = Optional
				.of(new ShelterAnimal(animalId, null, null, 0, null, null, null, null, null, null));

		ShelterAnimal updatedShelterAnimal = new ShelterAnimal(animalId, newShelterAnimal.getAnimalType(),
				newShelterAnimal.getName(), newShelterAnimal.getAge(), newShelterAnimal.getBreed(),
				newShelterAnimal.getGender(), newShelterAnimal.getSize(), newShelterAnimal.getLocation(),
				newShelterAnimal.getAdditionalInformation(), null);

		Mockito.when(this.repo.findById(animalId)).thenReturn(optionalShelterAnimal);

		Mockito.when(this.repo.save(updatedShelterAnimal)).thenReturn(updatedShelterAnimal);

		assertThat(this.service.updateShelterAnimal(animalId, newShelterAnimal)).isEqualTo(updatedShelterAnimal);

		Mockito.verify(this.repo, Mockito.times(1)).findById(animalId);

		Mockito.verify(this.repo, Mockito.times(1)).save(updatedShelterAnimal);
	}

	@Test
	void testDelete() {
		Long animalId = 1L;

		Mockito.when(this.repo.existsById(animalId)).thenReturn(true);

		assertThat(this.service.removeShelterAnimal(animalId)).isEqualTo(false);
	}

	@Test
	void testDeleteTest() {
		Long animalId = 1L;

		Mockito.when(this.repo.existsById(animalId)).thenReturn(false);

		assertThat(this.service.removeShelterAnimal(animalId)).isEqualTo(true);
	}
}
