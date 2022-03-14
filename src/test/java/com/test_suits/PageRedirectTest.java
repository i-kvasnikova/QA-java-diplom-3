package com.test_suits;

import com.package_objects.LoginPage;
import com.package_objects.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@DisplayName("Тестирование переходов между страницами")
public class PageRedirectTest extends BaseParamsSetup {
    LoginPage loginPage;

    @Before
    @DisplayName("Открыть главную страницу и нажать кнопку 'Личный кабинет'")
    public void goToLoginPage() {
        MainPage mainPage = openMainPage();
        mainPage.clickLoginButton();
        loginPage = page(LoginPage.class);
    }

    @Test
    @DisplayName("Переход по клику на 'Личный кабинет'")
    public void redirectFromMainToLogin() {
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getLoginPageUrl()));
    }

    @Test
    @DisplayName("Переход из 'Личного кабинета' конструктор по клику на 'Конструктор'")
    public void redirectFromLoginToMainByConstructor() {
        loginPage.clickConstructorButton();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getBaseUrl()));
    }

    @Test
    @DisplayName("Переход из 'Личного кабинета' конструктор по клику на логотип")
    public void redirectFromLoginToMainByLogo() {
        loginPage.clickSiteLogoButton();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getBaseUrl()));
    }
}
