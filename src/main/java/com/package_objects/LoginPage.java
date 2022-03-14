package com.package_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Map;

public class LoginPage extends PagesHeader {
    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Email')]//following-sibling::input")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Пароль')]//following-sibling::input")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(), 'Зарегистрироваться')]")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Войти')]")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(), 'Восстановить пароль')]")
    private SelenideElement restorePasswordButton;

    @FindBy(how = How.XPATH, using = ".//h2[contains(text(), 'Вход')]")
    private SelenideElement loginHeader;

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        registerButton.scrollTo();
        registerButton.click();
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
    }

    @Step("Нажать кнопку 'Восстановить пароль'")
    public void clickRestorePasswordButton() {
        restorePasswordButton.scrollTo();
        restorePasswordButton.click();
    }

    public String getPasswordFilledValue() {
        return passwordInput.getValue();
    }

    public String getEmailFilledValue() {
        return emailInput.getValue();
    }

    @Step("Заполнить поля для входа пользователя")
    public void fillInUserData(Map<String, String> user) {
        emailInput.setValue(user.get("email"));
        passwordInput.setValue(user.get("password"));
    }

    public boolean headerLoginIsVisible() {
        loginHeader.waitUntil(Condition.visible, 5000);
        return loginHeader.isDisplayed();
    }
}
