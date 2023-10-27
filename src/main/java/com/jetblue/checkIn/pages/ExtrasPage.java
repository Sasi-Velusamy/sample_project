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

public class ExtrasPage {

	public void travelerExtras(WebDriverWait driverWait, WebDriver driver, JavascriptExecutor executor) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.EXTRA_ADDITIONAL_BAGS))));
		boolean extrasTextStatus = driver.findElements(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.EXTRAS_HEADER))).size() > 0;
		if (extrasTextStatus) {
			WebElement speedSkipButton = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.SKIP_BUTTON)));
			speedSkipButton.click();
		}
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.EXTRA_ADDITIONAL_BAGS))));
		boolean bagsTextStatus = driver.findElements(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.BAGS_HEADER))).size() > 0;
		if (bagsTextStatus) {
			WebElement bagSkipButton = driver.findElement(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.SKIP_BUTTON)));
			bagSkipButton.click();
		}
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.SEAT_HEADER))));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.SKIP_BUTTON))));
		WebElement seatSkipButton = driver.findElement(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.SKIP_BUTTON)));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", seatSkipButton);

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.CHECKIN_HEADER))));
		WebElement getBoardingPassButton = driver.findElement(By.xpath(PropertyFileReader
				.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.GET_BOARDING_PASS_BUTTON)));
		getBoardingPassButton.click();
	}
}
