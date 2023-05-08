package ru.gloomyana.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SteamPage {

    public void openMainPage() {
        open("https://store.steampowered.com");
    }

    public void changeLanguage(String language) {
        $("#language_pulldown").click();
        $("#language_dropdown").$(byText(language)).click();
    }

    public void clickMenuItem(String menuItem) {
        $(".supernav_container").$(byText(menuItem)).click();
    }

    public void verifySteamAboutPageSubtitle() {
        $(".about_subtitle")
                .shouldHave(text("Steam — превосходная платформа для игроков и разработчиков."));
    }

    public void verifyClientDownloadButtonLinkIsClickable() {
        $(".about_install_steam_link")
                .shouldHave(text("Загрузить Steam"))
                .shouldHave(href("https://cdn.cloudflare.steamstatic.com/client/installer/steam.deb"))
                .shouldBe(and("Clickable", visible, enabled));
    }
}
