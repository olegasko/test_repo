package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    SelenideElement locationButton = $(".location-selector__button");
    SelenideElement locationsList = $(".location-selector__list");

    public void openLocationMenu() {
        locationButton.click();
    }

    public boolean isMenuVisible() {
        return locationsList.is(Condition.visible);
    }
}
