package com.test_suits;

import com.package_objects.MainPage;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@DisplayName("Тестирование переходов в разделе 'Конструктор'")
public class ConstructorElemsTest extends BaseParamsSetup {
    MainPage mainPage;

    @Before
    public void setUpAndOpenMainPage(){
        mainPage = openMainPage();
    }

    @Test
    @Step("Переход к разделу 'Булки'")
    public void clickOnContructorAreaBun() {
        mainPage.clickSauceTab();
        mainPage.clickBunTab();
        assertTrue(mainPage.headerBunIsDisplayed());
    }

    @Test
    @Step("Переход к разделу 'Соусы'")
    public void clickOnContructorAreaSauce() {
        mainPage.clickSauceTab();
        assertTrue(mainPage.headerSauceIsDisplayed());
    }

    @Test
    @Step("Переход к разделу 'Начинки'")
    public void clickOnContructorAreaFilling() {
        mainPage.clickFillingTab();
        assertTrue(mainPage.headerSauceIsDisplayed());
    }
}
