package com.package_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends PagesHeader {
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'BurgerConstructor_basket')]/button[text()='Войти в аккаунт']")
    protected SelenideElement btnLogin;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab_tab')]/span[text()='Булки']")
    protected SelenideElement tabBun;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    protected SelenideElement headerBun;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab_tab')]/span[text()='Соусы']")
    protected SelenideElement tabSauce;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    protected SelenideElement headerSauce;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab_tab')]/span[text()='Начинки']")
    protected SelenideElement tabFilling;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    protected SelenideElement headerFilling;

    public void clickBtnLogin() {
        btnLogin.scrollTo();
        btnLogin.click();
    }

    @Step("Нажать на вкладку 'Булки'")
    public void clickTabBun() {
        tabBun.scrollTo();
        tabBun.click();
    }
    @Step("Нажать на вкладку 'Соусы'")
    public void clickTabSauce() {
        tabSauce.scrollTo();
        tabSauce.click();
    }
    @Step("Нажать на вкладку 'Начинки'")
    public void clickTabFilling() {
        tabFilling.scrollTo();
        tabFilling.click();
    }

    public boolean headerBunIsDisplayed() {
        return headerBun.isDisplayed();
    }
    public boolean headerSauceIsDisplayed() {
        return headerSauce.isDisplayed();
    }
    public boolean headerFillingIsDisplayed() {
        return headerFilling.isDisplayed();
    }
}
