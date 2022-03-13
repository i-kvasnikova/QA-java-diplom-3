package com.package_objects;

import com.codeborne.selenide.SelenideElement;
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

    public void clickConstructorButton() {
        constructorButton.scrollTo();
        constructorButton.click();
    }

    public void clickOrderListButton() {
        orderListButton.scrollTo();
        orderListButton.click();
    }

    public void clickAccountButton() {
        accountButton.scrollTo();
        accountButton.click();
    }

    public void clickSiteLogoButton() {
        siteLogoButton.scrollTo();
        siteLogoButton.click();
    }
}
