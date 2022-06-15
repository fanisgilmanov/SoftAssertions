import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class SoftAssertions extends BaseTest{
    @Test
    void softAssertionsJunit5(){
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $$("ul.repo-list li ").first().$("a").shouldHave(text("selenide/selenide")).click();
        $$("#repository-container-header nav ul li").findBy(text("Wiki")).click();
        $$(".wiki-rightbar ul li button").findBy(text("Show 2 more pages…")).click();
        $$(".wiki-rightbar ul li").findBy(text("SoftAssertions")).shouldBe(visible).click();
        $$("#wiki-body h4").findBy(text("JUnit5")).sibling(0).$("pre").shouldNotBe(empty);;

    }

}
