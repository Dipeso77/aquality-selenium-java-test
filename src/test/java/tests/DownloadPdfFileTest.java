package tests;

import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DownloadPdfFileTest extends BaseTest {
    private final String languageValue = "en";
    private final String initText = "Albert Einstein";
    private final By switchLng= By.id("searchLanguage");
    private final By searchField= By.name("search");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By toolPage = By.xpath("//input[@id='vector-page-tools-dropdown-checkbox']");
    private final By downloadPdfButton = By.className("pdf-download-button");
    private final By downloadButton= By.xpath("//button[@type='submit']");
    private final By dowloadedFileX = By.xpath("//div[@class='mw-electronpdfservice-selection-label-desc']");

    @Test
    public void downloadPdfFileTest() {
        WebElement lngChange = driver.findElement(switchLng);
        lngChange.click();
        selectLanguage(languageValue);

        WebElement inputField = driver.findElement(searchField);
        inputField.sendKeys(initText);

        WebElement srchButton = driver.findElement(searchButton);
        srchButton.click();
        WebElement toolMenu = driver.findElement(toolPage);
        toolMenu.click();

        WebElement pdfButton = wait.until(ExpectedConditions.elementToBeClickable(downloadPdfButton));
        pdfButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
        WebElement finalDownloadBtn = driver.findElement(downloadButton);
        finalDownloadBtn.click();

        WebElement fileNameElement = driver.findElement(dowloadedFileX);
        String expectedFileName = fileNameElement.getText();
        File downloadedFile = new File(RELATIVE_RESOURCE_PATH, expectedFileName);

        Assert.assertTrue(isFileExists(downloadedFile), "File not downloaded!!");
    }

    public void selectLanguage(String languageValue) {
        WebElement languageDropdown = driver.findElement(switchLng);
        Select select = new Select(languageDropdown);
        select.selectByValue(languageValue);
    }

    private boolean isFileExists(File file) {
        try {
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        } catch (ConditionTimeoutException exception) {
            return false;
        }
        return true;
    }
}
