package pages;

import com.codeborne.selenide.WebDriverRunner;

public class InvestorsPage {

    public boolean isUrlCorrect(String url) {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(url);
    }
}
