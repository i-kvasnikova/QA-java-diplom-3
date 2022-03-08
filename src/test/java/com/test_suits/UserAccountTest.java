package com.test_suits;

import com.UserOperations;
import com.package_objects.AccountPage;
import com.package_objects.LoginPage;
import com.package_objects.RegisterPage;
import com.package_objects.RestorePasswordPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Epic("Тестирование действий над аккаунтом пользователя")
public class UserAccountTest extends BaseParamsSetup {
    @Test
    @Step("Зарегистрировать пользователя с валидными данными")
    public void registerUserWithValidData() {
        openMainPage().clickBtnLogin();
        page(LoginPage.class).clickBtnRegister();
        RegisterPage registerPage = page(RegisterPage.class);

        Map<String, String> userData = new UserOperations().getRandomUserData();
        registerPage.fillInUserData(userData);
        registerPage.clickBtnRegister();

        LoginPage loginPage = page(LoginPage.class);
        assertEquals(userData.get("email"), loginPage.getEmailFilledValue());
        assertEquals(userData.get("password"), loginPage.getPasswordFilledValue());

        //Для сохранения токена для последующего удаления пользователя
        new UserOperations().login(userData);
    }

    @Test
    @Step("Зарегистрировать пользователя с некорректным паролем")
    @Description("Пользователь не зарегистрирован, выдано сообщение об ошибке")
    public void registerUserWithInvalidPassword() {
        openMainPage().clickBtnLogin();
        page(LoginPage.class).clickBtnRegister();
        RegisterPage registerPage = page(RegisterPage.class);

        Map<String, String> userData = new UserOperations().getRandomUserData();
        userData.put("password", "312");
        registerPage.fillInUserData(userData);
        registerPage.clickBtnRegister();

        assertTrue(registerPage.isVisibleTextErrorMessage());
    }

    @Test
    @Step("Вход в аккаунт по кнопке «Войти в аккаунт» на главной")
    public void loginOnMainPage() {
        Map<String, String> userData = new UserOperations().register();
        openMainPage().clickBtnLogin();
        LoginPage loginPage = page(LoginPage.class);

        loginPage.fillInUserData(userData);
        loginPage.clickBtnLogin();
        loginPage.clickBtnAccount();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getProfilePageUrl()));

        page(AccountPage.class).clickBtnLogout();
    }

    @Test
    @Step("Вход в аккаунт через кнопку «Личный кабинет»")
    public void loginWithAccountHeaderBtn() {
        Map<String, String> userData = new UserOperations().register();
        openMainPage().clickBtnAccount();
        LoginPage loginPage = page(LoginPage.class);

        loginPage.fillInUserData(userData);
        loginPage.clickBtnLogin();
        loginPage.clickBtnAccount();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getProfilePageUrl()));

        page(AccountPage.class).clickBtnLogout();
    }

    @Test
    @Step("Вход в аккаунт через кнопку в форме регистрации")
    public void loginOnRegistrationPage() {
        Map<String, String> userData = new UserOperations().register();

        //Перейти в личный кабинет
        openMainPage().clickBtnLogin();
        //Перейти на форму регистрации
        page(LoginPage.class).clickBtnRegister();
        //Нажать кнопку 'Вход' на форме регистрации
        page(RegisterPage.class).clickBtnLogin();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillInUserData(userData);
        loginPage.clickBtnLogin();
        loginPage.clickBtnAccount();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getProfilePageUrl()));

        page(AccountPage.class).clickBtnLogout();
    }

    @Test
    @Step("Вход в аккаунт через кнопку в форме восстановления пароля")
    public void loginOnRestorePasswordPage() {
        Map<String, String> userData = new UserOperations().register();

        //Перейти в личный кабинет
        openMainPage().clickBtnLogin();
        //Перейти на форму восстановления пароля
        page(LoginPage.class).clickBtnRestorePassword();
        //Нажать кнопку 'Вход' на форме восстановления пароля
        page(RestorePasswordPage.class).clickBtnLogin();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillInUserData(userData);
        loginPage.clickBtnLogin();
        loginPage.clickBtnAccount();
        assertThat(webdriver().driver().url(), equalToIgnoringCase(apiConfig.getProfilePageUrl()));

        page(AccountPage.class).clickBtnLogout();
    }

    @Test
    @Step("Выход по кнопке «Выйти» в личном кабинете")
    public void logoutOnAccountPage() {
        Map<String, String> userData = new UserOperations().register();

        openMainPage().clickBtnAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillInUserData(userData);
        loginPage.clickBtnLogin();
        loginPage.clickBtnAccount();

        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickBtnLogout();

        assertTrue(loginPage.headerLoginIsVisible());
    }
}
