package com.jetblue.checkIn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jetblue.checkIn.constants.FilePathConstants;
import com.jetblue.checkIn.constants.LocatorKeyContainer;
import com.jetblue.checkIn.utils.PropertyFileReader;

public class AdditionalInfoPage {

	public void additionalInfo(WebDriverWait driverWait, WebDriver driver, JavascriptExecutor executor) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.EXTRA_ADDITIONAL_BAGS))));
		boolean additionalInfoStatus = driver.findElements(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.ADDITIONAL_INFO))).size() > 0;
		if (additionalInfoStatus) {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.MALE_CHECKBOX))));
			WebElement maleRadioButton = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.MALE_CHECKBOX)));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", maleRadioButton);
			WebElement dobMonth = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.DOB_MONTH)));
			WebElement dobDay = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.DOB_DAY)));
			WebElement dobYear = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.DOB_YEAR)));
			dobMonth.clear();
			dobMonth.sendKeys("01");
			dobDay.clear();
			dobDay.sendKeys("01");
			dobYear.clear();
			dobYear.sendKeys("1960");

			WebElement passportTextField = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.PASSPORT_TEXTFIELD)));
			passportTextField.clear();
			passportTextField.sendKeys("123456789123");
			WebElement expiryMonth = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.EXPIRY_MONTH)));
			WebElement expiryDay = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.EXPIRY_DAY)));
			WebElement expiryYear = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.EXPIRY_YEAR)));
			expiryMonth.clear();
			expiryMonth.sendKeys("05");
			expiryDay.clear();
			expiryDay.sendKeys("06");
			expiryYear.clear();
			expiryYear.sendKeys("2025");
			WebElement issuingCountry = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.ISSUING_COUNTRY)));
			issuingCountry.click();
			WebElement selectCountry = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.SELECT_COUNTRY)));
			selectCountry.clear();
			selectCountry.click();
			WebElement conButton = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CONTINUE_BUTTON)));
			conButton.click();
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.PERMANENT_RESIDENCY))));
			WebElement country = driver
					.findElement(By.xpath(PropertyFileReader.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH,
							LocatorKeyContainer.SELECT_PERMANENT_RESIDENCY)));
			country.click();
			WebElement countrySelection = driver
					.findElement(By.xpath(PropertyFileReader.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH,
							LocatorKeyContainer.SELECT_RESIDENCY_COUNTRY)));
			countrySelection.clear();
			countrySelection.click();
			WebElement continueLink = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CONTINUE_BUTTON)));
			continueLink.click();
		}
	}
}
