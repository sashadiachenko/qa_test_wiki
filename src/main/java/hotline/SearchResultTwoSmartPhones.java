package hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    @FindBy(xpath = "//a[contains(text(),'Смартфоны и мобильные телефоны')]")
    private WebElement finalComparisonButton;

    @FindBy(xpath = "//*[contains(text(),'Очистить список \"Cравнения\"')]")
    private WebElement clearButton;

    @FindBy(xpath = "//*[contains(text(),'Ваш список \"Сравнения\" пуст.')]")
    private WebElement checkClearButton;

    @FindBy(xpath = "//a[contains(text(),'HUAWEI P smart+ 4/64GB Black')]")
    private WebElement phone;

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static ComparisonOfTwoProducts comparisonOfTwoProducts;

    public SearchResultTwoSmartPhones(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        clickCheckboxs(driver);
        switchToNewPage(driver);
        deletePhones(driver);



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

       wait.until(ExpectedConditions.visibilityOf(finalComparisonButton));

       JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("arguments[0].click();", finalComparisonButton);

       }




    public void switchToNewPage(final WebDriver driver){
        String winHandleBefore = driver.getWindowHandle();

        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        ComparisonOfTwoProducts comparisonOfTwoProducts = new ComparisonOfTwoProducts(driver);


        driver.close();

       driver.switchTo().window(winHandleBefore);
    }

    public void deletePhones(final WebDriver driver){
        wait.until(ExpectedConditions.visibilityOf(clearButton));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", clearButton);


        wait.until(ExpectedConditions.visibilityOf(phone));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", comparisonButton);

         JavascriptExecutor jsq = (JavascriptExecutor)driver;
        jsq.executeScript("arguments[0].click();", comparisonButton);


    }




    public String getTextClearButton(){
        String text = checkClearButton.getText();
        return text;
    }
}
