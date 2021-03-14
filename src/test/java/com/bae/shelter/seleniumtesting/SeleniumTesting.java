package com.bae.shelter.seleniumtesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SeleniumTesting {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@Test
	void testBing() {
		this.driver.get("");

		WebElement username = this.driver.findElement(By.xpath(
				""));

		username.sendKeys("");

		WebElement password = this.driver.findElement(By.xpath(
				""));

		password.sendKeys("");

		WebElement saveButton = this.driver.findElement(By.xpath(
				""));

		saveButton.click();

		this.driver.get("");

		WebElement username2 = this.driver.findElement(By.xpath(
				""));

		username2.sendKeys("");

		WebElement password2 = this.driver.findElement(By.xpath(
				""));

		password2.sendKeys("");

		WebElement loginButton = this.driver.findElement(By.xpath(
				""));

		loginButton.click();

		WebElement login = this.driver
				.findElement(By.xpath(""));

		Assertions.assertTrue(login.getText().contains(""));

	}

	@AfterEach
	void tearDown() {
	this.driver.close();
}

}
}
