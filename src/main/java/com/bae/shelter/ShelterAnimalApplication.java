package com.bae.shelter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bae.shelter.domain.ShelterAnimal;

@SpringBootApplication
public class ShelterAnimalApplication {

	@Bean
	public List<ShelterAnimal> makeListBean() {
		List<ShelterAnimal> shelterAnimal = new ArrayList<>();
		shelterAnimal.add(new ShelterAnimal(1L, "Dog", "Archie", 4, "Cockapoo", "Male", "Medium",
				"East Riding of Yorkshire", "no additional information", null));
		return shelterAnimal;
	}

	public static void main(String[] args) {

	}

}
