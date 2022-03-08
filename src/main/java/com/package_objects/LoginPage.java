package com.package_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Map;

public class LoginPage extends PagesHeader {
    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Email')]//following-sibling::input")
    private SelenideElement inputEmail;

    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Пароль')]//following-sibling::input")
    private SelenideElement inputPassword;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(), 'Зарегистрироваться')]")
    private SelenideElement btnRegister;

    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Войти')]")
    private SelenideElement btnLogin;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(), 'Восстановить пароль')]")
    private SelenideElement btnRestorePassword;

    @FindBy(how = How.XPATH, using = ".//h2[contains(text(), 'Вход')]")
    private SelenideElement headerLogin;

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickBtnRegister() {
        btnRegister.scrollTo();
        btnRegister.click();
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickBtnLogin() {
        btnLogin.scrollTo();
        btnLogin.click();
    }

    @Step("Нажать кнопку 'Восстановить пароль'")
    public void clickBtnRestorePassword() {
        btnRestorePassword.scrollTo();
        btnRestorePassword.click();
    }

    public String getPasswordFilledValue() {
        return inputPassword.getValue();
    }

    public String getEmailFilledValue() {
        return inputEmail.getValue();
    }

    @Step("Заполнить поля для входа пользователя")
    public void fillInUserData(Map<String, String> user) {
        inputEmail.setValue(user.get("email"));
        inputPassword.setValue(user.get("password"));
    }

    public boolean headerLoginIsVisible() {
        headerLogin.waitUntil(Condition.visible, 5000);
        return headerLogin.isDisplayed();
    }
}
