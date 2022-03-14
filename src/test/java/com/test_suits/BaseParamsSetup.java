package com.test_suits;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.configuration.ApiConfig;
import com.package_objects.MainPage;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

@RunWith(Parameterized.class)
public class BaseParamsSetup {
    ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class);
    protected UserOperations userOperations;

    @Parameterized.Parameter
    public String webDriverName;

    @Before
    @Step("Установка конфигурации браузера")
    public void applySettings() {
        userOperations = new UserOperations();
        System.setProperty("webdriver.chrome.driver", apiConfig.getWebdriversPath() + webDriverName);
        Configuration.startMaximized = true;
    }

    @After
    @Step("Закрыть браузер и удалить пользователя (если создан)")
    public void tearDownMain (){
        webdriver().driver().close();
        userOperations.delete();
    }

    @Parameterized.Parameters(name = "Используемый драйвер: {0}")
    public static Object[] getUserData() {
        return new Object[][] {
                { "yandexdriver" },
                { "chromedriver" }
        };
    }

    @Step("Открыть главную страницу сайта")
    protected MainPage openMainPage() {
        return open(apiConfig.getBaseUrl(), MainPage.class);
    }
}