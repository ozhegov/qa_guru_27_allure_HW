package ozhegov.qa;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){

        open("https://github.com/");

    }

    @Step("Находим репозиторий {repo}")
    public void searchForRepo(String repo){

        $(".search-input").click();
        $("#query-builder-test").setValue(repo).pressEnter();

    }

    @Step("Открываем репозиторий {repo}")
    public void clickOnRepoLink(String repo){

        $(linkText(repo)).click();

    }

    @Step("Кликаем на таб Issue")
    public void clickOnIssueTab(){

        $("#issues-tab").click();

    }

    @Step("Проверяем, что Issue с названием {issueName} существует")
    public void checkIssueName(String issueName){

        $(".js-navigation-container").shouldHave(text(issueName));

    }


}
