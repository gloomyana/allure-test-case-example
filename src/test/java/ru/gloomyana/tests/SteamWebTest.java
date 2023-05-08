package ru.gloomyana.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SteamWebTest extends TestBase {

    @Test
    @DisplayName("Проверка наличия кнопки загрузки клиента на сайте STEAM")
    @Tags({@Tag("major"), @Tag("web")})
    public void steamClientDownloadButtonShouldBeClickableTest() {
        step("Открываем главную страницу Steam", () -> {
            steamPage.openMainPage();
        });
        step("Переходим на русскую версию сайта", () -> {
            steamPage.changeLanguage("Русский (Russian)");
        });
        step("Переходим в раздел \"O STEAM\"", () -> {
            steamPage.clickMenuItem("О STEAM");
            step("Проверяем что на странице есть текст  " +
                    "\"Steam — превосходная платформа для игроков и разработчиков.\"", () -> {
                steamPage.verifySteamAboutPageSubtitle();
            });
        });

        step("Проверяем, что есть кнопка с ссылкой для скачивания desktop клиента", () -> {
            steamPage.verifyClientDownloadButtonLinkIsClickable();
        });
    }
}
