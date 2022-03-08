package com.package_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePasswordPage extends PagesHeader {
    @FindBy(how = How.XPATH, using = ".//a[contains(text(), 'Войти')]")
    private SelenideElement btnLogin;

    @Step("Нажать кнопку 'Войти'")
    public void clickBtnLogin() {
        btnLogin.scrollTo();
        btnLogin.click();
    }
}
