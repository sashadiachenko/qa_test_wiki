package hotline;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HotlineSearchResult {


    @FindBy(xpath = "//*[@id='page-catalog']/div[1]/div[1]/div[1]/aside/div/div[3]/div[1]/div[4]/div[3]/ul[1]/li[9]/label/a")
    private WebElement checkBox;

    @FindBy(xpath = "//*[@id='catalog-products']/div[2]/ul/li[1]/div[1]/label")
    private WebElement samsungOne;

    @FindBy(xpath = "//*[@id='catalog-products']/div[2]/ul/li[2]/div[1]/label")
    private WebElement samsungTwo;

    @FindBy(xpath = "//*[@id='catalog-products']/div[2]/ul/li[3]/div[1]/label")
    private WebElement samsungThree;

    @FindBy(xpath = "//*[@id='page-catalog']/header/div[1]/div/div/div[2]/div[3]/div[1]/div")
    private WebElement comparison;

    @FindBy(xpath = "(//div[@data-dropdown-id='compare']//a)[1]")
    private WebElement finalText;


    private WebDriver driver;
    private WebDriverWait wait;


    public HotlineSearchResult(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        clickSamsung(driver);
        chooseSamsung(driver);
        getText();

    }

    public void  clickSamsung(final WebDriver driver) {

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", checkBox);
        wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(checkBox));
        checkBox.click();
       }

     public void chooseSamsung(final WebDriver driver) {

         wait.until(ExpectedConditions.visibilityOf(samsungOne));
         driver.findElements(By.id(String.valueOf(samsungOne)));
         samsungOne.click();

         wait.until(ExpectedConditions.visibilityOf(samsungTwo));
         driver.findElements(By.id(String.valueOf(samsungTwo)));
         samsungTwo.click();

         wait.until(ExpectedConditions.visibilityOf(samsungThree));
         driver.findElements(By.id(String.valueOf(samsungThree)));
         samsungThree.click();

         ((JavascriptExecutor) driver).executeScript("scroll(255, 0)");

         wait.until(ExpectedConditions.elementToBeClickable(comparison));
         comparison.click();


        }
      public String getText(){
          String finalTextComparison = finalText.getText();
          String comparisonText = StringUtils.substringAfter(finalTextComparison, ": ");
          wait.until(ExpectedConditions.visibilityOf(finalText));
          return comparisonText;

      }
}
