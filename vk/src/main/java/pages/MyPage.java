package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MyPage extends Form {

    private final IButton btnMyProfile = getElementFactory().getButton(By.xpath("//li[@id = 'l_pr']"),
            "My profile");


    public MyPage() {
        super(By.id("page_layout"), "My page");
    }

    public void clickMyProfile() {
        btnMyProfile.click();
    }
}
