package tests;

import configuration.Config;
import org.junit.jupiter.api.Test;
import ui.pages.Pages;

class SendEmailTests extends TestBase {

    @Test
    void sendEmailTest() throws InterruptedException {
        Pages.home.loginWithCorrectEmail()
                .sendEmail(Config.correctEmail, "Test subject", "Test body")
                .checkSuccessDialogVisible();
    }
}
