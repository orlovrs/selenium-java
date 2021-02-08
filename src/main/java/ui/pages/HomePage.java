package ui.pages;

import configuration.Config;
import extensions.Driver;
import extensions.PageElement;
import org.openqa.selenium.*;

public class HomePage {

    private PageElement loginTextbox = new PageElement(By.name("login"), "Поле ввода адреса без домена");
    private PageElement domainSelect = new PageElement(By.name("domain"), "Домен адреса");
    private PageElement goToPasswordButton = new PageElement(By.cssSelector("*[data-testid=\"enter-password\"]"), "Кнопка входа");
    private PageElement passwordTextbox = new PageElement(By.name("password"), "Поле ввода пароля");
    private PageElement submitButton = new PageElement(By.cssSelector("*[data-testid=\"login-to-mail\"]"), "Кнопка входа");

    public EmailsListPage loginWithCorrectEmail() {
        String email = Config.correctEmail.split("@")[0];
        String domain = "@" + Config.correctEmail.split("@")[1];

        Driver.sendKeys(loginTextbox, email);
        Driver.selectText(domainSelect, domain);
        Driver.click(goToPasswordButton);

        Driver.sendKeys(passwordTextbox, Config.correctPass);
        Driver.click(submitButton);

        return Pages.emailList;
    }
}
