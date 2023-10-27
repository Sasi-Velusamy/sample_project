package com.jetblue.checkIn.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jetblue.checkIn.constants.FilePathConstants;
import com.jetblue.checkIn.constants.LocatorKeyContainer;
import com.jetblue.checkIn.utils.PropertyFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckIn {
	public static WebDriver driver;
	public static JavascriptExecutor executor;
	public static WebDriverWait driverWait;

	public static String pnrCheckIn(String firstName, String lastName, String departureCity, String pnr) {
		try {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(PropertyFileReader.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH,
					LocatorKeyContainer.CHECKIN_URL));
			driver.manage().window().maximize();
			driverWait = new WebDriverWait(driver, Duration.ofSeconds(40));

			TripDetailsPage detailsPage = new TripDetailsPage();
			detailsPage.tripDetails(driverWait, driver, firstName, lastName, departureCity, pnr);

			TravelerDetailsPage travelerDetailsPage = new TravelerDetailsPage();
			travelerDetailsPage.travelerDetails(driverWait, driver);

			AdditionalInfoPage infoPage = new AdditionalInfoPage();
			infoPage.additionalInfo(driverWait, driver, executor);

			ExtrasPage extrasPage = new ExtrasPage();
			extrasPage.travelerExtras(driverWait, driver, executor);

			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.BOARDING_PASS_HEADER))));
			boolean qrCodeImageStatus = driver.findElements(By.xpath(PropertyFileReader
					.getValue(FilePathConstants.CHECKIN_LOCATOR_FILEPATH, LocatorKeyContainer.QR_CODE))).size() > 0;
			if (qrCodeImageStatus) {
				driver.quit();
				return "Passed";
			}
			driver.quit();
			return "Failed";
		} catch (Exception exception) {
			driver.quit();
			return "Failed";
		}
	}

}
