import org.junit.Test;
import java.util.List;

public class FindQaAutomationVacancies extends TestBase {


    @Test
    public void findQaVacancies()  {
        HomePage homePage = new HomePage(driver);
        log("Perform search with Qa Automation parameters and Lviv city");
        homePage.performSearch("Qa Automation");
        SearchPage searchPage = new SearchPage(driver);

        List<String> lvivCity = searchPage.getRowElementByVacancy();
        log("Perform search with Qa Automation parameters and Dnepr city");
        searchPage.dneprCitySearch();
        List<String> dneprCity = searchPage.getRowElementByVacancy();
        log("Perform search with Qa Automation parameters and Kyiv city");
        searchPage.kyivCitySearch();
        List<String> kyivCity = searchPage.getRowElementByVacancy();

        log("Write all information in console");
        System.out.println("Lviv vacancies: ");
        lvivCity.stream().forEach(System.out::println);
        System.out.println("------------------------------------");
        System.out.println("Dnepr vacancies: ");
        dneprCity.stream().forEach(System.out::println);
        System.out.println("------------------------------------");
        System.out.println("Kyiv vacancies: ");
        kyivCity.stream().forEach(System.out::println);


    }
}
