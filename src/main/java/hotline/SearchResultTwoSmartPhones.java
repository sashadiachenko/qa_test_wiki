package hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchResultTwoSmartPhones {


    @FindBy(xpath = "(//*[@class='tile-viewbox']//*[contains(@class,'type-checkbox')])[1]")
    private WebElement checkboxOne;

    @FindBy(xpath = "(//*[@class='tile-viewbox']//*[contains(@class,'type-checkbox')])[2]")
    private WebElement checkboxTwo;

    @FindBy(xpath = "//div[@class='item-compare']/span")
    private WebElement comparisonButton;

    @FindBy(xpath = "//div[@data-dropdown-id='compare']")
    private WebElement compare;

   // @FindBy(xpath = "//a[contains(text(),'Смартфоны и мобильные телефоны')]")
    @FindBy(xpath = "//*[@id='page-catalog']/header/div[1]/div/div/div[2]/div[3]/div[2]/div/ul/li[1]")
    private WebElement finalComparisonButton;

    @FindBy(xpath = "//a[contains(text(),'Xiaomi Redmi Note 5 4/64GB Black')]")
    private WebElement firstPhone;

    @FindBy(xpath = "//a[contains(text(),'Samsung Galaxy Note9 6/128GB Ocean Blue')]")
    private WebElement secondPhone;

    @FindBy(xpath = "//*[contains(text(),'Очистить список \"Cравнения\"')]")
    private WebElement clearButton;

    @FindBy(xpath = "//*[contains(text(),'Ваш список \"Сравнения\" пуст.')]")
    private WebElement checkClearButton;

    private static WebDriver driver;
    private static WebDriverWait wait;

    public SearchResultTwoSmartPhones(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        clickCheckboxs(driver);


    }

    public void clickCheckboxs(final WebDriver driver){
       wait = new WebDriverWait(driver,30);

       wait.until(ExpectedConditions.visibilityOf(checkboxOne));
       checkboxOne.click();

       wait.until(ExpectedConditions.visibilityOf(checkboxTwo));
       checkboxTwo.click();

       ((JavascriptExecutor) driver).executeScript("scroll(255, 0)");

       wait.until(ExpectedConditions.visibilityOf(comparisonButton));
       comparisonButton.click();

       wait.until(ExpectedConditions.elementToBeClickable(compare));
       driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", finalComparisonButton);

        switchToNewPage(driver);

        clickCheckboxs(driver);






     }

     public String getTextFirstPhone(){
        String testPhone = firstPhone.getText();
        return testPhone;
     }

    public String getTextSecondPhone(){
        String testPhone = secondPhone.getText();
        return testPhone;
    }


    public void switchToNewPage(final WebDriver driver){
        String winHandleBefore = driver.getWindowHandle();

        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();

        driver.switchTo().window(winHandleBefore);
    }
    public void clearButton(WebDriver driver){
        comparisonButton.click();
        wait.until(ExpectedConditions.visibilityOf(clearButton));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", clearButton);
    }

    public String getTextClearButton(){
        String text = clearButton.getText();
        return text;
    }
}
