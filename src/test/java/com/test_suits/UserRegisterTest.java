package com.test_suits;

import com.package_objects.LoginPage;
import com.package_objects.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DisplayName("Тестирование регистрации пользователя")
public class UserRegisterTest extends BaseParamsSetup {
    RegisterPage registerPage;
    Map<String, String> userData;

    @Before
    public void setUp() {
        openMainPage().clickLoginButton();
        page(LoginPage.class).clickRegisterButton();
        registerPage = page(RegisterPage.class);
        userData = userOperations.getRandomUserData();
    }

    @Test
    @Step("Зарегистрировать пользователя с валидными данными")
    public void registerUserWithValidData() {
        registerPage.fillInUserData(userData);
        registerPage.clickRegisterButton();

        LoginPage loginPage = page(LoginPage.class);
        assertEquals(userData.get("email"), loginPage.getEmailFilledValue());
        assertEquals(userData.get("password"), loginPage.getPasswordFilledValue());

        //Сохраняем токен для последующего удаления пользователя
        userOperations.login(userData);
    }

    @Test
    @Step("Зарегистрировать пользователя с некорректным паролем")
    @Description("Пользователь не зарегистрирован, выдано сообщение об ошибке")
    public void registerUserWithInvalidPassword() {
        userData.put("password", "312");
        registerPage.fillInUserData(userData);
        registerPage.clickRegisterButton();

        assertTrue(registerPage.isVisibleErrorMessageText());
    }
}
