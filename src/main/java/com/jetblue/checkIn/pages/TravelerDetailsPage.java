package com.jetblue.checkIn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jetblue.checkIn.constants.FilePathConstants;
import com.jetblue.checkIn.constants.LocatorKeyContainer;
import com.jetblue.checkIn.utils.PropertyFileReader;

public class TravelerDetailsPage {

	public void travelerDetails(WebDriverWait driverWait, WebDriver driver) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.REGULATION_TRAVELER))));
		boolean regulationStatus = driver.findElements(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.EU_REGULATION))).size() > 0;
		System.out.println(regulationStatus);
		if (regulationStatus) {
			WebElement regulationConButton = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CONTINUE_BUTTON)));
			regulationConButton.click();
		}
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.SELECT_TRAVELER))));
		boolean selectAllTravelerButtonStatus = driver.findElements(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.SELECT_ALL_TRAVELER)))
				.size() > 0;
		if (selectAllTravelerButtonStatus) {
			WebElement selectAllTravelerButton = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.SELECT_ALL_TRAVELER)));
			selectAllTravelerButton.click();
			WebElement continueButton = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CONTINUE_BUTTON)));
			continueButton.click();
		} else {
			boolean continueButtonStatus = driver.findElements(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CONTINUE_BUTTON)))
					.size() > 0;
					System.out.println(continueButtonStatus);
					System.out.println(PropertyFileReader
							.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CONTINUE_BUTTON));
			WebElement continueButton = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CONTINUE_BUTTON)));
			continueButton.click();
		}
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.HAZARDOUS_MATERIALS))));
		WebElement continueButton = driver.findElement(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CONTINUE_BUTTON)));
		continueButton.click();
	}
}
