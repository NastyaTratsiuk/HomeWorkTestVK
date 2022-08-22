package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PasswordPage extends Form {

    private final ITextBox txtPassword = getElementFactory().getTextBox(By.xpath("//input[@name = 'password']"),
            "Password");
    private final IButton btnNext = getElementFactory().getButton(By.xpath("//div[@class = 'vkc__Button__title']"),
            "Next");

    public PasswordPage() {
        super(By.xpath("//form[contains(@class,'EnterPasswordNoUserInfo')]"), "Password");
    }

    public void inputTxtPassword(String text) {
        txtPassword.clearAndType(text);
    }

    public void clickBtnNext() {
        btnNext.click();
    }

}
