package wikipedia;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import wikipedia.WikipediaMainPage;
import wikipedia.WikipediaSearchResult;

import java.util.concurrent.TimeUnit;

public class WikipediaTestSuit {

    private static WebDriver driver;
    private static WikipediaMainPage searchInput;
    private static WikipediaMainPage wikipediaMainPage;




    @Before
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://uk.wikipedia.org/wiki/%D0%93%D0%BE%D0%BB%D0%BE%D0%B2%D0%BD%D0%B0_%D1%81%D1%82%D0%BE%D1%80%D1%96%D0%BD%D0%BA%D0%B0");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void verifyWikipediaText() {
        wikipediaMainPage = new WikipediaMainPage(driver);
        searchInput = new WikipediaMainPage(driver);

        wikipediaMainPage.setSearchInput("Java");

        WikipediaSearchResult wikipediaSearchResult = wikipediaMainPage.clickButton();



        String mainLable = wikipediaSearchResult.getMainLableText();
        Assert.assertEquals("Java", mainLable);







    }

    @After
    public void closeBrowser(){
        driver.close();
    }


}
