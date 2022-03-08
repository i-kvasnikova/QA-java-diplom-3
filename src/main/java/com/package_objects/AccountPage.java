package com.package_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage extends PagesHeader {
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Выход')]")
    private SelenideElement btnLogout;

    @Step("Нажать кнопку 'Выход'")
    public void clickBtnLogout() {
        btnLogout.scrollTo();
        btnLogout.click();
    }
}
