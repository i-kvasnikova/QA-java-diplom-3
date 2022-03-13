package com.test_suits;

import com.package_objects.MainPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@Epic("Тестирование переходов в разделе 'Конструктор'")
public class ConstructorElemsTest extends BaseParamsSetup {
    @Test
    @Step("Переход к разделу 'Булки'")
    public void clickOnContructorAreaBun() {
        MainPage mainPage = openMainPage();
        mainPage.clickSauceTab();
        mainPage.clickBunTab();
        assertTrue(mainPage.headerBunIsDisplayed());
    }

    @Test
    @Step("Переход к разделу 'Соусы'")
    public void clickOnContructorAreaSauce() {
        MainPage mainPage = openMainPage();
        mainPage.clickSauceTab();
        assertTrue(mainPage.headerSauceIsDisplayed());
    }

    @Test
    @Step("Переход к разделу 'Начинки'")
    public void clickOnContructorAreaFilling() {
        MainPage mainPage = openMainPage();
        mainPage.clickFillingTab();
        assertTrue(mainPage.headerSauceIsDisplayed());
    }
}
