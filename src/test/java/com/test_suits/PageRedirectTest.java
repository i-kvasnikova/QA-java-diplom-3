package com.test_suits;

import com.package_objects.LoginPage;
import com.package_objects.MainPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Тестирование переходов между страницами")
public class PageRedirectTest extends BaseParamsSetup {
    @Test
    @Step("Переход по клику на 'Личный кабинет'")
    public void redirectFromMainToLogin() {
        MainPage mainPage = openMainPage();
        mainPage.clickBtnLogin();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getLoginPageUrl()));
    }

    @Test
    @Step("Переход из 'Личного кабинета' конструктор по клику на 'Конструктор'")
    public void redirectFromLoginToMainByConstructor() {
        MainPage mainPage = openMainPage();
        mainPage.clickBtnLogin();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickBtnConstructor();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getBaseUrl()));
    }

    @Test
    @Step("Переход из 'Личного кабинета' конструктор по клику на логотип")
    public void redirectFromLoginToMainByLogo() {
        MainPage mainPage = openMainPage();
        mainPage.clickBtnLogin();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickBtnSiteLogo();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getBaseUrl()));
    }
}
