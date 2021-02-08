package ui.components;

import extensions.Driver;
import extensions.PageElement;
import org.openqa.selenium.By;

public class EmailSuccessfullySentComponent {

    private PageElement successLink = new PageElement(By.cssSelector(".layer-sent-page a"), "Сообщение об успешной отправке письма");

    public Boolean isSuccessfulDialogPresent() {
        return Driver.isDisplayed(successLink) && Driver.containsText(successLink, "Письмо отправлено");
    }
}
