package hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotlineMainPage {
    private static WebDriver driver;
    private static Actions actions;
    private static WebDriverWait wait;

   @FindBy(xpath = "//*[@id='page-index']//span[text()='Смартфоны и мобильные телефоны']")
    private WebElement smartfoneTelefon;

    private static final String PRODUCT_PHONE = "//*[@id='page-index']/div[1]/div[1]/div[2]/aside/nav/ul/li[18]/a";

    public HotlineMainPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        hover(driver);
        smartPhone(driver);


    }

    public void hover(final WebDriver driver){
        actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(PRODUCT_PHONE));
        actions.moveToElement(element);
        actions.perform();

    }


    public void smartPhone(final WebDriver driver){
        wait = new WebDriverWait(driver ,30);
        wait.until(ExpectedConditions.visibilityOf(smartfoneTelefon));
        smartfoneTelefon.click();
    }

}
