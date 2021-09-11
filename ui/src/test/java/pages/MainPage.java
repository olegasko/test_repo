package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

//TODO refactor extend main page, move not common things in separate classes
public class MainPage {

    SelenideElement locationButton = $(".location-selector__button");
    SelenideElement locationsList = $(".location-selector__list");


    public void openLocationMenu() {
        locationButton.click();
    }

    public boolean isMenuVisible() {
        return locationsList.should(Condition.appear).is(Condition.visible);
    }

    public boolean isLocationCorrect(String location) {
        return locationButton.should(Condition.appear).getText().equals(location);
    }

    public void activateLocation(String region, String lang) {
        SelenideElement LocationButton = $x(".//ul[@class='location-selector__list']//a[text()='" + region +" ']");
        String location = region + " (" + lang + ")";
        if (!isLocationCorrect(location)) LocationButton.click();
    }
}


