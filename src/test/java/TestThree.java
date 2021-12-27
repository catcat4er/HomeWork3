
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestThree {

    @Test
    void selenideSearchOnGithub () {
        open ("https://github.com/");

// Откройте страницу Selenide в Github
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();

//Перейдите в раздел Wiki проекта
        $(".UnderlineNav-body [href='/selenide/selenide/wiki']").click();

// Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".filter-bar").$("input").setValue("sof");
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();

// Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".application-main").shouldHave(text("Using JUnit5 extend test class"));

        Selenide.closeWebDriver();
    }
}
