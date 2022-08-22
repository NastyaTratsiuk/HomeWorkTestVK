package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {

    private final IButton btnSignIn = getElementFactory().getButton(By.xpath("//button[contains(@class,'signInButton')]"),
            "Sign in");

    public HomePage() {
        super(By.id("index_login"), "Login");
    }

    public void clickBtnSignIn() {
        btnSignIn.click();
    }
}
