import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFormTest {
    @BeforeAll
    static void beforeTestSuit() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        sleep(4000);
        $("#firstName").setValue("Ilya");
        $(byId("lastName")).setValue("Prokofiew");
        $(by("id", "userEmail")).setValue("IlyaNot@mail.ru");
        $(byText("Male")).click();
        $x("//input[@id='userNumber']").setValue("79772621133");
        setDateOfBirth("04 Feb 2025");
        $(byId("subjectsInput")).setValue("someSubject");
        $(byText("Sports")).click();
        $(byId("uploadPicture")).uploadFromClasspath("files/picture.jpg");
        $(byId("currentAddress")).setValue("Pushkina Strasse");
        $(byId("react-select-3-input")).setValue("Haryana").pressEnter();
        $(byId("react-select-4-input")).setValue("Karnal").pressEnter();
        $(byId("submit")).click();
        sleep(4000);
    }


    private void setDateOfBirth(String date) {
        SelenideElement el = $("#dateOfBirthInput");
        el.click();
        el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        el.sendKeys(date);
        el.sendKeys(Keys.ENTER);
    }
}
