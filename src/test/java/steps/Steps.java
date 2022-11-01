package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.assertj.core.api.Assertions;
import pages.MainPage;
import utils.PropertyUtils;

import static com.codeborne.selenide.Selenide.open;

public class Steps {

    private final MainPage mainPage;

    public Steps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    String price;
    String url;
    String name;

    @Дано("пользователь на главной странице")
    public void userOnMainPage() {
        open(PropertyUtils.getBaseUrl());
    }

    @И("^пользователь выбирает категорию \"(.*)\"$")
    public void selectCategory(String text) {
        mainPage.SelectCategory(text);
    }

    @И("^пользователь выбирает регион \"(.*)\"$")
    public void selectRegion(String text) {
        mainPage.SelectRegion(text);
    }

    @И("пользователь отмечает чекбокс Только с фото")
    public void checkBoxPhotoCheck() {
        mainPage.checkBoxPhotoCheck();
    }

    @И("^пользователь ищет \"(.*)\"$")
    public void userSearch(String text) {
        mainPage.userSearch(text);
    }

    @Тогда("пользователь сохраняет цену первого найденного элемента")
    public void saveFirstElementPrice() {
        price = mainPage.saveFirstElementPrice();
    }

    @Тогда("пользователь сохраняет url объявления")
    public void saveFirstElementUrl() {
        url = mainPage.saveFirstElementUrl();
    }

    @И("пользователь сохраняет имя первого объявления")
    public void saveFirstElementName() {
        name = mainPage.saveFirstElementName();
    }

    @И("пользователь добавляет первое объявление в избранное")
    public void saveFirstElementToFavorites() {
        mainPage.saveFirstElementToFavorites();
    }

    @Тогда("пользователь проверяет имя первого объявления в избранном")
    public void checkFirstElementInFavorites() {
        open(PropertyUtils.getBaseUrl() + "/favorites");
        String currentName = mainPage.checkFirstElementInFavorites();
        Assertions.assertThat(name.equals(currentName));
    }
}
