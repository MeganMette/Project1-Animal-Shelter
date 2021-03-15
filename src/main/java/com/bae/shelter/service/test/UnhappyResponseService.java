package com.bae.shelter.service.test;

public class UnhappyResponseService implements ResponseService {

	@Override
	public String generateResponse() {
		return "Somethings wrong";
	}
}
