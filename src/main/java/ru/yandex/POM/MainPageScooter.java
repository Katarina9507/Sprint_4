package ru.yandex.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPageScooter {
    private WebDriver driver;
    private By createOrderButtonUp = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    private By createOrderButtonDown = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");
    private final String url = "https://qa-scooter.praktikum-services.ru/";  //URL сайта

    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void openBrowser() {
        driver.get(url);
    }

    public void clickOrderButton(String locator) {
        WebElement element = driver.findElement(createOrderButtonDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(createOrderButtonDown).click();
    }

    public String compareText(int number) {
        String accordionHeading_id = "accordion__heading-" + number; //Локатор вопросов о важном
        String accordionPanel_id = "accordion__panel-" + number; //Локатор ответов о важном
        By accordionHeading = By.id(accordionHeading_id);
        By accordionPanel = By.id(accordionPanel_id);
        WebElement element = driver.findElement(accordionHeading);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading).click();
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(accordionPanel)).getText();
    }
}