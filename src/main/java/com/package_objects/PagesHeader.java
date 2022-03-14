package com.package_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PagesHeader {
    @FindBy(how = How.XPATH, using = ".//a[contains(@class, 'AppHeader_header')]/p[text()='Конструктор']")
    protected SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//a[contains(@class, 'AppHeader_header')]/p[text()='Лента Заказов']")
    protected SelenideElement orderListButton;

    @FindBy(how = How.XPATH, using = ".//a[contains(@class, 'AppHeader_header')]/p[text()='Личный Кабинет']")
    protected SelenideElement accountButton;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'AppHeader_header__logo')]")
    protected SelenideElement siteLogoButton;

    @Step("Нажать кнопку 'Конструктор'")
    public void clickConstructorButton() {
        constructorButton.scrollTo();
        constructorButton.click();
    }

    @Step("Нажать кнопку 'Лента Заказов'")
    public void clickOrderListButton() {
        orderListButton.scrollTo();
        orderListButton.click();
    }

    @Step("Нажать кнопку 'Личный Кабинет'")
    public void clickAccountButton() {
        accountButton.scrollTo();
        accountButton.click();
    }

    @Step("Нажать на логотип сайта")
    public void clickSiteLogoButton() {
        siteLogoButton.scrollTo();
        siteLogoButton.click();
    }
}
