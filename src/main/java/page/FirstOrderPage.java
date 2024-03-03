package page;

import org.openqa.selenium.*;
import java.lang.*;

// Пеовая страница заказа
public class FirstOrderPage {
    private WebDriver driver;

    //поле ввода имени
    private By nameInput = By.xpath("//*[@placeholder='* Имя']");
    //поле ввода фамилии
    private By famInput = By.xpath("//*[@placeholder='* Фамилия']");
    //поле ввода адреса
    private By adresInput = By.xpath("//*[contains(@placeholder,'* Адрес')]");
    //поле ввода станции
    private By stationInput = By.xpath("//*[contains(@placeholder,'* Станция')]");
    //поле ввода телефона
    private By telInput = By.xpath("//*[contains(@placeholder,'* Телефон')]");
    //кнопка заказа
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public void fillFirstForm(String Name, String Fam, String Adress, String Station, String Number) throws InterruptedException {
        driver.findElement(nameInput).sendKeys(Name);
        driver.findElement(famInput).sendKeys(Fam);
        driver.findElement(adresInput).sendKeys(Adress);
        Thread.sleep(471);
        driver.findElement(stationInput).click();
        Thread.sleep(471);
        driver.findElement(By.xpath("//*[contains(text(), '"+Station+"')]/parent::button")).click();
        driver.findElement(telInput).sendKeys(Number);
        Thread.sleep(111);
        driver.findElement(nextButton).click();
    }
    public FirstOrderPage (WebDriver driver){
        this.driver = driver;
    }
}