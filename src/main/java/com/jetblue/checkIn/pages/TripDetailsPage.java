package com.jetblue.checkIn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.jetblue.checkIn.constants.FilePathConstants;
import com.jetblue.checkIn.constants.LocatorKeyContainer;
import com.jetblue.checkIn.utils.PropertyFileReader;

public class TripDetailsPage {

	public void tripDetails(WebDriverWait driverWait, WebDriver driver, String firstName, String lastName,
			String departureCity, String pnr) {

		driver.switchTo().frame(PropertyFileReader.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH,
				LocatorKeyContainer.FRAME_ACCEPT_COOKIE));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.ACCEPT_COOKIES))));
		driver.findElement(By.xpath(PropertyFileReader.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH,
				LocatorKeyContainer.ACCEPT_COOKIES))).click();
		driver.switchTo().parentFrame();

		WebElement firstNameTextField = driver.findElement(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.FIRSTNAME_TEXTFIELD)));
		WebElement lastNameTextField = driver.findElement(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.LASTNAME_TEXTFIELD)));
		WebElement departureTextField = driver.findElement(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.DEPARTURE_CITY_TEXTFIELD)));
		WebElement pnrTextField = driver.findElement(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.PNR_TEXTFIELD)));
		WebElement checkInButton = driver.findElement(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CHECKIN_BUTTON)));
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		departureTextField.sendKeys(departureCity + Keys.ENTER);
		pnrTextField.sendKeys(pnr);
		checkInButton.click();
	}
}
