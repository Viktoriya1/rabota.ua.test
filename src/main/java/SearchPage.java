import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPage extends TestBase {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameOfVacancy = By.cssSelector(".f-visited-enable.ga_listing");
    private By nameOfCompany = By.cssSelector(".f-text-dark-bluegray.f-visited-enable");
    private By nameOfCity = By.cssSelector(".f-vacancylist-characs-block.fd-f-left-middle");

    private By search = By.cssSelector("#content_HorizontalContainer1_lnkSearch");
    private By clickOnDropDown = By.cssSelector("input[name='ctl00$content$HorizontalContainer1$CityPickerWork$inpCity']");
    private By kyivCity = By.xpath("//*[@id=\"ui-id-2\"]/li[2]");
    private By dneprCity = By.xpath("//*[@id=\"ui-id-2\"]/li[3]");


    public List<String> getRowElementByVacancy() {
        List<WebElement> vacancies = driver.findElement(By.cssSelector("tbody")).findElements(By.cssSelector("tr"));

        List<String> wholeDescription = new ArrayList<String>(Arrays.asList());


        for (int i = 0; i < 5; i++) {
            String vacancyDescripton = "";
            WebElement element = vacancies.get(i);
            vacancyDescripton += "Name of vacancy: " + " " + element.findElement(nameOfVacancy).getText() + " "
                    + "City name: " + " " + element.findElement(nameOfCity).getText() + " "
                    + "Name of company: " + " " + element.findElement(nameOfCompany).getText();

            wholeDescription.add(vacancyDescripton);
        }
        return wholeDescription;
    }


    public SearchPage clickSearchButton() {
        driver.findElement(search).click();
        return new SearchPage(driver);
    }


    public SearchPage selectKyivCity() {
        driver.findElement(clickOnDropDown).click();
        driver.findElement(kyivCity).click();
        return new SearchPage(driver);
    }


    public SearchPage kyivCitySearch() {
        this.selectKyivCity();
        this.clickSearchButton();
        return new SearchPage(driver);
    }

    public SearchPage selectDneprCity()  {
        driver.findElement(clickOnDropDown).click();
        driver.findElement(dneprCity).click();
        return new SearchPage(driver);
    }


    public SearchPage dneprCitySearch() {
        this.selectDneprCity();
        this.clickSearchButton();
        return new SearchPage(driver);
    }

}
