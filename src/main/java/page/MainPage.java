package page;


import org.openqa.selenium.*;
import java.lang.*;

// Класс главной страницы
public class MainPage {
    private WebDriver driver;
    //кнопка заказа в шапке
    private By headerOrderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");

    //кнопка заказа на странице
    private By orderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    public void orderHeaderClick(){
        driver.findElement(headerOrderButton).click();
    }

    public void openQuesttionText(String QuestionText) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[text()='"+QuestionText+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath("//*[text()='"+QuestionText+"']")).click();
        Thread.sleep(300);
    }

    public boolean answerIsDisplay(String AnsverText){
        return driver.findElement(By.xpath("//*[text()='"+AnsverText+"']")).isDisplayed();
    }

    public MainPage (WebDriver driver){
        this.driver = driver;
    }
}