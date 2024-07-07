package ozhegov.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubIssueTests extends TestBase{

    @Test
    public void checkIssueName(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("allure-framework/allure2").pressEnter();
        $(linkText("allure-framework/allure2")).click();
        $("#issues-tab").click();
        $(".js-navigation-container").shouldHave(text("How to add a new column to Allure CSV metadata?"));


    }

}
