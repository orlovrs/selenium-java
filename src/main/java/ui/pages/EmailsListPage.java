package ui.pages;

import extensions.Driver;
import extensions.PageElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import ui.components.CreateEmailComponent;
import ui.components.EmailSuccessfullySentComponent;

public class EmailsListPage {

    private PageElement newEmailButton = new PageElement(By.cssSelector("*[data-title-shortcut='N']"), "Кнопка создания письма");

    private CreateEmailComponent createEmailDialog = new CreateEmailComponent();
    private EmailSuccessfullySentComponent successfulSentDialog = new EmailSuccessfullySentComponent();

    public EmailsListPage sendEmail(String email, String subject, String body) {
        Driver.click(newEmailButton);
        createEmailDialog.sendEmail(email, subject, body);

        return this;
    }

    public EmailsListPage checkSuccessDialogVisible() {
        Assertions.assertTrue(successfulSentDialog.isSuccessfulDialogPresent(), "Диалог об успешной отправке письма не виден на экране");

        return this;
    }
}
