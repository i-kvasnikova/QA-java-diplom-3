package com.test_suits;

import com.package_objects.AccountPage;
import com.package_objects.LoginPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

@DisplayName("Тестирование выхода из аккаунта пользователя")
public class UserLogoutTest extends BaseParamsSetup {
    Map<String, String> userData;
    LoginPage loginPage;

    @Before
    public void setUp() {
        userData = userOperations.register();
        loginPage = page(LoginPage.class);
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void logoutOnAccountPage() {
        openMainPage().clickAccountButton();
        loginPage.fillInUserData(userData);
        loginPage.clickLoginButton();
        loginPage.clickAccountButton();

        page(AccountPage.class).clickLogoutButton();
        assertTrue(loginPage.headerLoginIsVisible());
    }
}
