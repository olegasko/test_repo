package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

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
        return locationsList.is(Condition.visible);
    }

    public boolean isLocationUkraineUA() {
        return locationButton.getText().equals("Україна (UA)");
    }

    public boolean isLocationGlobalEN() {
        return locationButton.getText().equals("Global (EN)");
    }

    public void activateLocationGlobalEN() {
        if (!isLocationGlobalEN()) LocationGlobalENButton.click();
    }

    public void activateLocationUkraineUA() {
        if (!isLocationUkraineUA()) LocationUkraineUAButton.click();
    }
}
