package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class CommonPage {

    SelenideElement cookiesBannerButton = $x("//button[@aria-label='Accept our use of cookies']/span[text()='Accept']");
    SelenideElement locationButton = $(".location-selector__button");
    SelenideElement locationsList = $(".location-selector__list");
    SelenideElement investorsButton = $x(".//ul[@class='footer__links']//a[text()='Investors']");

    public static boolean isUrlCorrect(String url) {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(url);
    }

    public void closeCookiesBanner() {
        if (cookiesBannerButton.isDisplayed()) cookiesBannerButton.click();
    }

    public void openLocationMenu() {
        locationButton.click();
    }

    public boolean isLocationMenuVisible() {
        return locationsList.should(Condition.appear).is(Condition.visible);
    }

    public boolean isLocationCorrect(String location) {
        return locationButton.should(Condition.appear).getText().equals(location);
    }

    public void activateLocation(String region, String lang) {
        SelenideElement LocationButton = $x(".//ul[@class='location-selector__list']//a[text()='" + region + " ']");
        String location = region + " (" + lang + ")";
        if (!isLocationCorrect(location)) LocationButton.click();
    }

    public void openInvestorsPage() {
        closeCookiesBanner();
        investorsButton.click();
    }
    public void clickOnLink(String linkName){
        SelenideElement Link = $x("//a[string()='"+ linkName + "' and contains(@class, 'top-navigation__item-link')]");
        Link.click();
    }

    public boolean isPageCorrect(String pageName) {
        SelenideElement Title = $x("//h1");
        return Title.getText().contains(pageName);
    }


}
