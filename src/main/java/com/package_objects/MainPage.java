package com.package_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends PagesHeader {
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'BurgerConstructor_basket')]/button[text()='Войти в аккаунт']")
    protected SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab_tab')]/span[text()='Булки']")
    protected SelenideElement bunTab;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    protected SelenideElement bunHeader;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab_tab')]/span[text()='Соусы']")
    protected SelenideElement sauceTab;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    protected SelenideElement sauceHeader;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab_tab')]/span[text()='Начинки']")
    protected SelenideElement fillingTab;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    protected SelenideElement fillingHeader;

    @Step("Нажать на кнопку 'Личный кабинет'")
    public void clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
    }

    @Step("Нажать на вкладку 'Булки'")
    public void clickBunTab() {
        bunTab.scrollTo();
        bunTab.click();
    }
    @Step("Нажать на вкладку 'Соусы'")
    public void clickSauceTab() {
        sauceTab.scrollTo();
        sauceTab.click();
    }
    @Step("Нажать на вкладку 'Начинки'")
    public void clickFillingTab() {
        fillingTab.scrollTo();
        fillingTab.click();
    }

    public boolean headerBunIsDisplayed() {
        return bunHeader.isDisplayed();
    }
    public boolean headerSauceIsDisplayed() {
        return sauceHeader.isDisplayed();
    }
    public boolean headerFillingIsDisplayed() {
        return fillingHeader.isDisplayed();
    }
}
