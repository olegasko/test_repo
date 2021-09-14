package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class InvestorsPage extends CommonPage {

    String listOfLinksActualXpath = ".//section//ul[contains(@class,'list')]/*";
    SelenideElement listOfLinksActualElement = $x(listOfLinksActualXpath);
    ElementsCollection listOfLinksActualCollection = $$x(listOfLinksActualXpath);

    public boolean isListOfLinksVisible() {
        return listOfLinksActualElement.should(Condition.appear).is(Condition.visible);
    }

    public boolean isListOfLinksHasCorrectOrder(List<String> listOfLinks) {
        ArrayList<String> listOfLinksActual = new ArrayList<>();
        for (int listItemPosition = 0;
             listItemPosition < listOfLinksActualCollection.size();
             listItemPosition++) {
            listOfLinksActual.add(listItemPosition, listOfLinksActualCollection.get(listItemPosition).getText());
        }
        return listOfLinksActual.equals(listOfLinks);
    }
}
