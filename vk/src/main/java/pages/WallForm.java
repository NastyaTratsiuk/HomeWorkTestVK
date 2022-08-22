package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import responses.Wall;
import org.openqa.selenium.By;

public class WallForm extends Form {


    private final ILabel getLabelWallPost(int userId) {
        return getElementFactory().getLabel(By.xpath(String.format("//div[@id=''%s'_'%d'']//div[contains(@class,'zoom_text')]", userId,
                Wall.getPostId())), "Text wall post");
    }

    private final ILabel getLabelWallPostOwnerId(int userId) {
        return getElementFactory().getLabel(By.xpath(String.format("//div[@id ='post'%s'_'%d'']//a[@class = 'author']",
                userId, Wall.getPostId())), "Owner id wall post");
    }

    private final ILabel getLabelCommitPost(int userId) {
        return getElementFactory().getLabel(By.xpath(String.format("//div[@id=replies'%s'_'%s']",
                userId, Wall.getPostId())), "Commit post");
    }

    private final ILabel getLabelAuthorCommitPost(int userId) {
        return getElementFactory().getLabel(By.xpath(String.format("//div[@id=replies'%s'_'%s']//a[@class = 'author']",
                userId, Wall.getPostId())), "Author commit post");
    }

    private final IButton getButtonLike(int userId) {
        return getElementFactory().getButton(By.xpath(String.format("//div[@id ='post'%s'_'%d'']//span[contains(@class,'like_button')]",
                        userId, Wall.getPostId())),
                "Like");
    }

    private final ILabel getLabelPost(int userId) {
        return getElementFactory().getLabel(By.id(String.format("post'%s'_'%d'", userId, Wall.getPostId())), "Post");
    }

    public WallForm() {
        super(By.id("page_layout"), "My page");
    }

    public String getTextPostWall(int userId) {
        return getLabelWallPost(userId).getText();
    }

    public String getOwnerIdPostWall(int userId) {
        return getLabelWallPostOwnerId(userId).getAttribute("data-from-id");
    }

    public String getAuthorCommitPostWall(int userId) {
        return getLabelAuthorCommitPost(userId).getAttribute("data-from-id");
    }

    public boolean isCommitPostWall(int userId) {
        return getLabelCommitPost(userId).state().waitForDisplayed();
    }

    public void clickLike(int userId) {
        getButtonLike(userId).click();
    }

    public boolean isDeletePost(int userId) {
        return getLabelPost(userId).state().isDisplayed();
    }
}
