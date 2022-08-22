package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LoginPage extends Form {

    private final ITextBox txtLogin = getElementFactory().getTextBox(By.xpath("//input[@name = 'login']"),
            "Login");
    private final IButton btnContinue = getElementFactory().getButton(By.xpath("//div[@class = 'vkc__Button__title']"),
            "Continue");

    public LoginPage() {
        super(By.xpath("//form[contains(@class,'EnterLogin')]"), "Login");
    }

    public void inputTxtLogin(String text) {
        txtLogin.clearAndType(text);
    }

    public void clickBtnContinue() {
        btnContinue.click();
    }
}
