package com.test_suits;

import com.package_objects.AccountPage;
import com.package_objects.LoginPage;
import com.package_objects.RegisterPage;
import com.package_objects.RestorePasswordPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@DisplayName("Тестирование входа в аккаунт пользователя")
public class UserLoginTest extends BaseParamsSetup {
    Map<String, String> userData;
    LoginPage loginPage;

    @Before
    public void setUp() {
       userData = userOperations.register();
       loginPage = page(LoginPage.class);
    }

    @After
    public void tearDown() {
        page(AccountPage.class).clickLogoutButton();
    }

    @Test
    @DisplayName("Вход в аккаунт по кнопке «Войти в аккаунт» на главной")
    public void loginOnMainPage() {
        openMainPage().clickLoginButton();

        registerAndGoToAccountPage();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getProfilePageUrl()));
    }

    @Test
    @DisplayName("Вход в аккаунт через кнопку «Личный кабинет»")
    public void loginWithAccountHeaderButton() {
        openMainPage().clickAccountButton();

        registerAndGoToAccountPage();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getProfilePageUrl()));
    }

    @Test
    @DisplayName("Вход в аккаунт через кнопку в форме регистрации")
    public void loginOnRegistrationPage() {
        openMainPage().clickLoginButton();
        loginPage.clickRegisterButton();
        page(RegisterPage.class).clickLoginButton();

        registerAndGoToAccountPage();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getProfilePageUrl()));
    }

    @Test
    @DisplayName("Вход в аккаунт через кнопку в форме восстановления пароля")
    public void loginOnRestorePasswordPage() {
        openMainPage().clickLoginButton();
        loginPage.clickRestorePasswordButton();
        page(RestorePasswordPage.class).clickLoginButton();

        registerAndGoToAccountPage();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getProfilePageUrl()));
    }

    private void registerAndGoToAccountPage() {
        loginPage.fillInUserData(userData);
        loginPage.clickLoginButton();
        loginPage.clickAccountButton();
    }
}
