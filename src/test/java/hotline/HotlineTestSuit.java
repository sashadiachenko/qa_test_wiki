package hotline;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HotlineTestSuit {

    private static WebDriver driver;
    private static HotlineMainPage hotlineMainPage;
    private static HotlineSearchResult hotlineSearchResult;
    private static SearchResultTwoSmartPhones searchResultTwoSmartPhones;
    private static ComparisonOfTwoProducts comparisonOfTwoProducts;


    @Before
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://hotline.ua/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }

  /*  @Test
    public void verifyHotlineNumber () {
        hotlineMainPage = new HotlineMainPage(driver);
        hotlineSearchResult = new HotlineSearchResult(driver);
        Assert.assertEquals("3", hotlineSearchResult.getText()  );

     }*/

    @Test
    public void verifyButtonClear(){
        hotlineMainPage = new HotlineMainPage(driver);
        searchResultTwoSmartPhones = new SearchResultTwoSmartPhones(driver);
        comparisonOfTwoProducts = new ComparisonOfTwoProducts(driver);


        Assert.assertEquals("Xiaomi Redmi Note 5 4/64GB Black",comparisonOfTwoProducts.getTextFirstPhone());

        Assert.assertEquals("Samsung Galaxy Note 9 6/128GB Ocean Blue (SM-N960FZBD)",comparisonOfTwoProducts.getTextSecondPhone());

        Assert.assertEquals("Ваш список \"Сравнения\" пуст.", searchResultTwoSmartPhones.getTextClearButton());

    }


    @After
    public void closeBrowser(){
        driver.close();
    }
}
