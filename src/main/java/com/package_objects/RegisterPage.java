package com.package_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Map;

public class RegisterPage extends PagesHeader {
    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Имя')]//following-sibling::input")
    private SelenideElement inputName;

    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Email')]//following-sibling::input")
    private SelenideElement inputEmail;

    @FindBy(how = How.XPATH, using = ".//label[contains(text(), 'Пароль')]//following-sibling::input")
    private SelenideElement inputPassword;

    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Зарегистрироваться')]")
    private SelenideElement btnRegister;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(), 'Войти')]")
    private SelenideElement btnLogin;

    @FindBy(how = How.XPATH, using = ".//p[contains(text(), 'Некорректный пароль')]")
    private SelenideElement textErrorMessage;

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

    @Step("Заполнить поля для регистрации пользователя")
    public void fillInUserData(Map<String, String> user) {
       inputName.setValue(user.get("name"));
       inputEmail.setValue(user.get("email"));
       inputPassword.setValue(user.get("password"));
    }

    public boolean isVisibleTextErrorMessage() {
        return textErrorMessage.isDisplayed();
    }
}
