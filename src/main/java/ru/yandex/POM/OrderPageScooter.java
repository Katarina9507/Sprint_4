package ru.yandex.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPageScooter {

    private WebDriver driver;
    private By nameField = By.xpath(".//input[@placeholder='* Имя']"); //Поле ввода имени
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']"); //Поле фамилии
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //Поле ввода адреса
    private By metroStationField = By.cssSelector(".select-search__value .select-search__input"); //Поле выбора станции метро
    private By metroStationTwo = By.xpath(".//input[@placeholder='* Станция метро']"); //Поле выбора станции метро
    private By choosingFirstMetroValue = By.xpath(".//li[@data-index='0']"); // Выбор первого значения в выпадающем списке метро
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //Поле ввода телефона
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка Далее
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //Поле выбора даты доставки самоката
    private By dateTwo = By.xpath(".//div[@class='react-datepicker__week']/div[@aria-label='Choose пятница, 10-е марта 2023 г.']"); //Поле выбора даты
    private By timeField = By.className("Dropdown-control"); //Поле выбора времени
    private By timeTwo = By.xpath(".//div[@class='Dropdown-menu']/div[3]"); //Поле выбора времени для теста
    private By colourBlack = By.id("black"); //Поле выбора цвета, чёрный
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']"); //Поле ввода комментария
    private By rentButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]"); //Кнокпка "Заказать", для открытия окна подвтерждения заказа
    private By approveButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]"); //Кнопка "Да" в сплывающем окне заказа
    private By successfully = By.className("Order_ModalHeader__3FDaJ"); //Локатор теста успешного заказа


    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void makingAnOrder(String nameText, String surnameText, String addressText, String metroStationText, String phoneNumber, String commentText) {
        driver.findElement(nameField).sendKeys(nameText);
        driver.findElement(surnameField).sendKeys(surnameText);
        driver.findElement(addressField).sendKeys(addressText);
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationTwo).sendKeys(metroStationText);
        driver.findElement(choosingFirstMetroValue).click();
        driver.findElement(phoneField).sendKeys(phoneNumber);
        driver.findElement(nextButton).click();
        driver.findElement(dateField).click();
        driver.findElement(dateTwo).click();
        driver.findElement(timeField).click();
        driver.findElement(timeTwo).click();
        driver.findElement(colourBlack).click();
        driver.findElement(commentField).sendKeys(commentText);
        driver.findElement(rentButton).click();
    }
    public void clickApproveButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(approveButton)).click();
    }

    public String getOrderConfirmationText() {
        return driver.findElement(successfully).getText();
    }
}