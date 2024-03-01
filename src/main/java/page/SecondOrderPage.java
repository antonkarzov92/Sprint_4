package page;

import org.openqa.selenium.*;
import java.lang.*;

// Вторая страница заказа
public class SecondOrderPage {
    private WebDriver driver;
    //поле ввода даты
    private By whenInput = By.xpath("//*[contains(@placeholder,'* Когда')]");
    //выпадающий список срока аренды
    private By timeDropdown = By.cssSelector(".Dropdown-control div");
    //чекбокс выбора чёрного цвета
    private By blackCheckBox = By.id("black");
    //чекбокс выбора серого цвета
    private By greyCheckBox = By.id("grey");
    //поле ввода комментария
    private By commentInput = By.xpath("//*[contains(@placeholder,'Комментарий')]");
    //кнопка Заказа
    private By orderFinalButton = By.cssSelector(".Order_Buttons__1xGrp button + button");

    //кнопка Да
    private By yesButton = By.cssSelector(".Order_Modal__YZ-d3 button + button");

    public void fillSecondForm(String Comment, String Data, String Time, String Color) throws InterruptedException {
        driver.findElement(commentInput).sendKeys(Comment);
        driver.findElement(timeDropdown).click();
        Thread.sleep(471);
        driver.findElement(By.xpath("//*[contains(text(), '"+Time+"')]")).click();
        switch(Color){
            case "black":
                driver.findElement(blackCheckBox).click();
                break;
            case "grey":
                driver.findElement(greyCheckBox).click();
                break;
        }
        driver.findElement(whenInput).sendKeys(Data);
        driver.findElement(whenInput).sendKeys(Keys.ENTER);
        driver.findElement(orderFinalButton).click();
        Thread.sleep(471);
        driver.findElement(yesButton).click();
    }
    public SecondOrderPage (WebDriver driver){
        this.driver = driver;
    }
    public boolean orderIs(){
        return driver.findElement(By.xpath("//*[text()='Заказ оформлен']")).isDisplayed();
    }


}