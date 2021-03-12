package com.bae.shelter.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShelterAnimal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long animalId;
	private String animalType;
	private String name;
	private int age;
	private String breed;
	private String gender;
	private String size;
	private String location;
	private String additionalInformation;

	public ShelterAnimal(Long animalId, String animalType, String name, int age, String breed, String gender,
			String size, String information, String additionalInformation, String location) {
		super();
		this.animalId = animalId;
		this.animalType = animalType;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.gender = gender;
		this.size = size;
		this.location = location;
		this.additionalInformation = additionalInformation;
	}

	public ShelterAnimal(String animalType, String name, int age, String breed, String gender, String size,
			String information, String additionalInformation, String location) {
		super();
		this.animalType = animalType;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.gender = gender;
		this.size = size;
		this.location = location;
		this.additionalInformation = additionalInformation;
	}

	public ShelterAnimal() {

	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public Long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Long animalId) {
		this.animalId = animalId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalInformation == null) ? 0 : additionalInformation.hashCode());
		result = prime * result + age;
		result = prime * result + ((animalId == null) ? 0 : animalId.hashCode());
		result = prime * result + ((animalType == null) ? 0 : animalType.hashCode());
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShelterAnimal other = (ShelterAnimal) obj;
		if (additionalInformation == null) {
			if (other.additionalInformation != null)
				return false;
		} else if (!additionalInformation.equals(other.additionalInformation))
			return false;
		if (age != other.age)
			return false;
		if (animalId == null) {
			if (other.animalId != null)
				return false;
		} else if (!animalId.equals(other.animalId))
			return false;
		if (animalType == null) {
			if (other.animalType != null)
				return false;
		} else if (!animalType.equals(other.animalType))
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

}
