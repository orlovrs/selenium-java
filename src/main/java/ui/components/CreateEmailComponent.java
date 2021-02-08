package ui.components;

import extensions.Driver;
import extensions.PageElement;
import org.openqa.selenium.By;

public class CreateEmailComponent {

    private PageElement addressTextbox = new PageElement(By.cssSelector("*[data-type='to'] input"), "Поле ввода адресата");
    private PageElement subjectTextbox = new PageElement(By.name("Subject"), "Тема письма");
    private PageElement bodyTextbox = new PageElement(By.cssSelector("*[role=\"textbox\"]"), "Кнопка входа");
    private PageElement sendEmailButton = new PageElement(By.cssSelector("*[data-title-shortcut=\"Ctrl+Enter\"]"), "Кнопка отправки письма");

    public void sendEmail(String email, String subject, String body) {
        Driver.sendKeys(addressTextbox, email);
        Driver.sendKeys(subjectTextbox, subject);
        Driver.sendKeys(bodyTextbox, body);
        Driver.click(sendEmailButton);
    }
}
