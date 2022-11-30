package ru.yandex;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.runners.Parameterized;
import ru.yandex.POM.MainPageScooter;
import ru.yandex.POM.OrderPageScooter;
import main.BrowserRule;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class RentPageScooterTest {
    private final String button;

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public RentPageScooterTest(String button) {
        this.button = button;
    }

    @Parameterized.Parameters
    public static Object[][] getLocator() {
        return new Object[][]{
                {".Header_Nav__AGCXC .Button_Button__ra12g"},
                {".Home_FinishButton__1_cWm .Button_Button__ra12g"},
        };
    }

    @Test
    public void shouldOrderScooterForSendLoginFirstVersionToClickButtonUp() {
        OrderPageScooter objOrderPageScooter = new OrderPageScooter(browserRule.getDriver());
        MainPageScooter objMainPageScooter = new MainPageScooter(browserRule.getDriver());
        objMainPageScooter.openBrowser();
        objMainPageScooter.clickOrderButton(button);
        objOrderPageScooter.makingAnOrder("Тест", "Тестовый", "Часовая 13", "Черкизовская", "+79111111111", "ТЕСТ");
        objOrderPageScooter.clickApproveButton();
        String expected = "Заказ оформлен";
        String actual = objOrderPageScooter.getOrderConfirmationText();
        MatcherAssert.assertThat(actual, containsString(expected));

    }
}