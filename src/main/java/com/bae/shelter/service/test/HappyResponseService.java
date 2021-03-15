package com.bae.shelter.service.test;

public class HappyResponseService implements ResponseService {

	@Override
	public String generateResponse() {
		return "Everything is working squeaky clean";
	}
}
