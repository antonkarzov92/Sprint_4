import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeOptions;
import page.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String Name;
    private final String Fam;
    private final String adress;
    private final String metro;
    private final String tel;
    private final String com;
    private final String data;
    private final String time;
    private final String color;

    public OrderTest(String Name, String Fam, String adress, String metro, String tel, String com, String data, String time, String color) {
        this.Name = Name;
        this.Fam = Fam;
        this.adress = adress;
        this.metro = metro;
        this.tel = tel;
        this.com = com;
        this.data = data;
        this.time = time;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {"Антон", "Карзов","Москва","Бульвар Рокоссовского","89167972929","Оставьте у двери", "07.02.2024", "двое суток", "black"},
                {"Дима", "Тестов","Тестовск","Черкизовская","89777777777","Позвоните", "11.12.2024", "сутки", "grey"},
        };
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
public void test() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.orderHeaderClick();
        //первое окно
        FirstOrderPage firsnOrderPage = new FirstOrderPage(driver);
        firsnOrderPage.fillFirstForm(Name,Fam,adress,metro,tel);
        //второе окно
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        secondOrderPage.fillSecondForm(com, data, time, color);
        //проверяем, что заказ создался
        assertTrue(secondOrderPage.orderIs());
    }
}

