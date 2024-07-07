package ozhegov.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GitHubIssueWithStepAnnotationTests extends TestBase{

    private static final String REPOSITORY = "allure-framework/allure2";
    private static final String ISSUE_NAME = "How to add a new column to Allure CSV metadata?";

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка соответствия названия Issue")
    public void checkIssueName(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepo(REPOSITORY);
        steps.clickOnRepoLink(REPOSITORY);
        steps.clickOnIssueTab();
        steps.checkIssueName(ISSUE_NAME);

    }

}
