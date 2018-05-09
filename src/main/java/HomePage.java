import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends TestBase {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By inputDescriptionOfVacancy = By.cssSelector(".keyword.ui-autocomplete-input");
    private By openDropDownList = By.cssSelector("input[name='ctl00$content$vacSearch$CityPickerWork$inpCity']");
    private By searchButton = By.cssSelector(".fd-text-center.ft-f1");
    private By lvivCity = By.xpath("//*[@id=\"ui-id-2\"]/li[8]");


    public HomePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new HomePage(driver);
    }

    public HomePage inputDescriptionOfVacancy(String nameOfVacancy) {
        driver.findElement(inputDescriptionOfVacancy).sendKeys(nameOfVacancy);
        return new HomePage(driver);
    }


    public HomePage selectLvivCity()  {
        driver.findElement(openDropDownList).click();
        driver.findElement(lvivCity).click();
        return new HomePage(driver);
    }


    public SearchPage performSearch(String nameOfVacancy) {
        this.inputDescriptionOfVacancy(nameOfVacancy);
        this.selectLvivCity();
        this.clickSearchButton();
        return new SearchPage(driver);
    }
}
