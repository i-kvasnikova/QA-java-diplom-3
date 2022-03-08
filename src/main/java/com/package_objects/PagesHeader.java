package com.package_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PagesHeader {
    @FindBy(how = How.XPATH, using = ".//a[contains(@class, 'AppHeader_header')]/p[text()='Конструктор']")
    protected SelenideElement btnConstructor;

    @FindBy(how = How.XPATH, using = ".//a[contains(@class, 'AppHeader_header')]/p[text()='Лента Заказов']")
    protected SelenideElement btnOrderList;

    @FindBy(how = How.XPATH, using = ".//a[contains(@class, 'AppHeader_header')]/p[text()='Личный Кабинет']")
    protected SelenideElement btnAccount;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'AppHeader_header__logo')]")
    protected SelenideElement btnSiteLogo;

    public void clickBtnConstructor() {
        btnConstructor.scrollTo();
        btnConstructor.click();
    }

    public void clickBtnOrderList() {
        btnOrderList.scrollTo();
        btnOrderList.click();
    }

    public void clickBtnAccount() {
        btnAccount.scrollTo();
        btnAccount.click();
    }

    public void clickBtnSiteLogo() {
        btnSiteLogo.scrollTo();
        btnSiteLogo.click();
    }
}
