import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.junit.*;
import page.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static page.Driver.createDriver;


@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;

    //можем выбрать параметром, на какую кнопку нажимать при тесте через параметр, 1 - в шапке, другое - на странице
    private final int buttonForOrder;
    private final String driverType ="firefox";

    private final String Name;
    private final String Fam;
    private final String address;
    private final String metro;
    private final String tel;
    private final String com;
    private final String data;
    private final String time;
    private final String color;


    public OrderTest(int buttonForOrder, String Name, String Fam, String address, String metro, String tel, String com, String data, String time, String color) {
        this.buttonForOrder = buttonForOrder;
        this.Name = Name;
        this.Fam = Fam;
        this.address = address;
        this.metro = metro;
        this.tel = tel;
        this.com = com;
        this.data = data;
        this.time = time;
        this.color = color;
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
public void test() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.orderHeaderClick(buttonForOrder);
        //первое окно
        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        firstOrderPage.fillFirstForm(Name,Fam,address,metro,tel);
        //второе окно
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        secondOrderPage.fillSecondForm(com, data, time, color);
        //проверяем, что заказ создался
        assertTrue("не работает кнопка под номером " + buttonForOrder,secondOrderPage.orderIs());
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {1,"Антон", "Карзов","Москва","Бульвар Рокоссовского","89167972929","Оставьте у двери", "07.02.2024", "двое суток", "black"},
                {2,"Дима", "Тестов","Тестовск","Черкизовская","89777777777","Позвоните", "11.12.2024", "сутки", "grey"},
        };

    }
}

