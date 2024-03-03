import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static page.Driver.createDriver;

import java.lang.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import page.*;

@RunWith(Parameterized.class)
    public class TextTest {
    private WebDriver driver;
    private final String driverType ="chrome";
    private final String question;
    private final String answer;
    public TextTest( String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    @Before
    public void setUp() {
        driver = createDriver(driverType);
    }

    @After
    public void teardown() {
        driver.quit();
    }

        @Test
        public void test2() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.get("https://qa-scooter.praktikum-services.ru/");
            MainPage mainPage = new MainPage(driver);
            mainPage.openQuesttionText(question);
            assertTrue(mainPage.answerIsDisplay(answer));
        }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
            };
     }

    }

