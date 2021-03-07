package com.bae.shelter.domain;

public class ShelterAnimal {
	private int animalId;
	private String animalType;
	private String name;
	private int age;
	private String breed;
	private String gender;
	private String size;
	private String location;
	private String additionalInformation;

	public ShelterAnimalController(int AnimalId, String animalType, String name, int age, String breed, String gender, String size,
			String information, String additionalInformation, String location, int animalId) {
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

	public ShelterAnimalController() {
		super();
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

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

}
