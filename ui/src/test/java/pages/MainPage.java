package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

//TODO refactor extend main page, move not common things in separate classes
public class MainPage {

    SelenideElement locationButton = $(".location-selector__button");
    SelenideElement locationsList = $(".location-selector__list");
    SelenideElement LocationGlobalENButton = $x(".//ul[@class='location-selector__list']//a[text()='Global ']");
    SelenideElement LocationUkraineUAButton = $x(".//ul[@class='location-selector__list']//a[text()='Україна ']");


    public void openLocationMenu() {
        locationButton.click();
    }

    public boolean isMenuVisible() {
        return locationsList.should(Condition.appear).is(Condition.visible);
    }

    public boolean isLocationCorrect(String location) {
        return locationButton.should(Condition.appear).getText().equals(location);
    }

    public void activateLocation(String location) {
        boolean check = isLocationCorrect(location);
        if (!check ) {
            switch (location) {
                case "Global (EN)":
                    LocationGlobalENButton.click();
                    break;
                case "Україна (UA)":
                    LocationUkraineUAButton.click();
            }
        }
    }


}
