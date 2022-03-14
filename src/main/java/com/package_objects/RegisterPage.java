package com.package_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Map;

public class RegisterPage extends PagesHeader {
    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Имя')]//following-sibling::input")
    private SelenideElement nameInput;

    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Email')]//following-sibling::input")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Пароль')]//following-sibling::input")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Зарегистрироваться')]")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(), 'Войти')]")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//p[contains(text(), 'Некорректный пароль')]")
    private SelenideElement errorMessageText;

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

    @Step("Заполнить поля для регистрации пользователя")
    public void fillInUserData(Map<String, String> user) {
       nameInput.setValue(user.get("name"));
       emailInput.setValue(user.get("email"));
       passwordInput.setValue(user.get("password"));
    }

    public boolean isVisibleErrorMessageText() {
        return errorMessageText.isDisplayed();
    }
}
