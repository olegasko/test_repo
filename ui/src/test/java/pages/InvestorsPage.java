package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;

public class InvestorsPage {

    SelenideElement listOfLinks = $x(".//section//ul[contains(@class,'list')]/*");

    public boolean isUrlCorrect(String url) {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(url);
    }


    public boolean isListOfLinksVisible() {
        return listOfLinks.should(Condition.appear).is(Condition.visible);
    }

    public boolean isListOfLinksHasCorrectOrder() {
        return false;
    }
}
