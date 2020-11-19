package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppOrderTest {
    @Test
    public void happyPath(){
        open("http://localhost:9999/");
        SelenideElement form = $(By.tagName("FORM"));
        form.$("[data-test-id=name] input").setValue("Иванов Иван Иванович");
        form.$("[data-test-id=phone] input").setValue("+79876543210");
        form.$("[data-test-id=agreement]").click();
        form.$(By.tagName("BUTTON")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена!"));
//        $(By.name("name")).setValue("Иванов Иван Иванович");
//        $(By.name("phone")).setValue("+79876543210");
//        $(By.name("agreement")).click();
//        $(By.tagName("button")).click();
//        $(By.className("alert-success")).shouldHave(Condition.exactText("Ваша заявка успешно принята!"));
    }
}
