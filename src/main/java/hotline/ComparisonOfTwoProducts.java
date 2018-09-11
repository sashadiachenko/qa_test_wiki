package hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparisonOfTwoProducts {

    @FindBy(xpath = "//a[contains(text(),'Xiaomi Redmi Note 5 4/64GB Black')]")
    private WebElement firstPhone;

    @FindBy(xpath = "//a[contains(text(),'Samsung Galaxy Note 9 6/128GB Ocean Blue')]")
    private WebElement secondPhone;

    private static WebDriver driver;

    public ComparisonOfTwoProducts(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextFirstPhone(){
        String testPhone = firstPhone.getText();
        return testPhone;
    }

    public String getTextSecondPhone(){
        String testPhone = secondPhone.getText();
        return testPhone;
    }
}
