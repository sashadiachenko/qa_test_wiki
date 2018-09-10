package wikipedia;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchResult {

    @FindBy(xpath = "//h1[@id='firstHeading']")
    private WebElement mainLable;

    public WikipediaSearchResult(final WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    public String getMainLableText(){
        final String mainLableText = mainLable.getText();
        String finalMainLableText = StringUtils.substringBefore(mainLableText,"[");
       // StringUtils.substringBefore(mainLableText, ".");
        //System.out.print(mainLableText);
       // String finalMainLableText = mainLableText.substring(0, 4);
       // System.out.print(finalMainLableText);

        return finalMainLableText;

    }





}
