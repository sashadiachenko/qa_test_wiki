package wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaMainPage {

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@id='searchButton']")
    private WebElement searchButton;

    private WebDriver driver;

    public WikipediaMainPage (final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setSearchInput(final String searchText){
        searchInput.sendKeys(searchText);
    }

    public WikipediaSearchResult clickButton(){
        searchButton.click();
        return new WikipediaSearchResult(driver);
    }

}
