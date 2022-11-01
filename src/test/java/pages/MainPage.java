package pages;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class MainPage {

    public void SelectCategory(String text) {
        $("select#category").selectOption(text);
    }

    public void SelectRegion(String text) {
        $("div[data-marker='search-form/region']").click();
        $("input[data-marker='popup-location/region/input']").sendKeys(text);
        $("li[data-marker='suggest(0)']").shouldHave(text(text));
        $("li[data-marker='suggest(0)']").click();
        $("input[data-marker='popup-location/region/input']").shouldHave(value(text));
        $("button[data-marker='popup-location/save-button']").click();
    }

    public void checkBoxPhotoCheck() {
        if (!$("input[data-marker='search-form/with-images']").isSelected()) {
            $("input[data-marker='search-form/with-images']").parent().click();
        }
    }

    public void userSearch(String text) {
        $("input[data-marker='search-form/suggest']").sendKeys(text);
        $("button[data-marker='search-form/submit-button']").click();
    }

    public String saveFirstElementPrice() {
        return $$("div[data-marker=item]").get(0).find("span[class*=price-text]").text();
    }

    public String saveFirstElementUrl() {
        return $$("div[data-marker=item]").get(0).find("a").attr("href");
    }

    public String saveFirstElementName() {
        return $$("div[data-marker*='block-item']").get(0).find("h3").text();
    }

    public void saveFirstElementToFavorites() {
        $$("div[data-marker*='block-item']").get(0).find("div[data-marker='favorite']").click();
    }

    public String checkFirstElementInFavorites() {
        return $$("div[data-marker^='item']").get(0).find("p").text();
    }

}
