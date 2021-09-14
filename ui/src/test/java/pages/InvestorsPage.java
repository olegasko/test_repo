package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class InvestorsPage extends CommonPage {

    String listOfLinksActualXpath = ".//section//ul[contains(@class,'list')]/*";

    public boolean isListOfLinksVisible() {
        return $x(listOfLinksActualXpath).should(Condition.appear).is(Condition.visible);
    }

    public boolean isListOfLinksHasCorrectOrder(List<String> listOfLinks) {
        List<String> listOfLinksActualList = $$x(listOfLinksActualXpath).stream().map(SelenideElement::getText).collect(Collectors.toList());
        return listOfLinks.equals(listOfLinksActualList);
    }
}
