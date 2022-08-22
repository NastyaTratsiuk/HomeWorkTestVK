import aquality.selenium.browser.AqualityServices;
import responses.Likes;
import responses.Wall;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.Config;
import utils.RandomUtils;

public class VKTestClass extends BaseTest {

    @Test
    public void VKTest() {
        AqualityServices.getBrowser().goTo(Config.URL);
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home Page isn't open.");
        homePage.clickBtnSignIn();
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.state().waitForDisplayed(), "Login Page isn't open.");
        loginPage.inputTxtLogin(Config.LOGIN);
        loginPage.clickBtnContinue();
        PasswordPage passwordPage = new PasswordPage();
        Assert.assertTrue(passwordPage.state().waitForDisplayed(), "Password Page isn't open.");
        passwordPage.inputTxtPassword(Config.PASSWORD);
        passwordPage.clickBtnNext();
        MyPage myPage = new MyPage();
        Assert.assertTrue(myPage.state().waitForDisplayed(), "My profile isn't open.");
        myPage.clickMyProfile();
        Wall.postTextMessageToTheWall(RandomUtils.generateString(Config.RANDOM_SIZE));
        WallForm wallForm = new WallForm();
        Assert.assertEquals(wallForm.getTextPostWall(Config.OWNER_ID), Wall.getTextPost(), "Text doesn't much.");
        Assert.assertEquals(wallForm.getOwnerIdPostWall(Config.OWNER_ID), Config.OWNER_ID, "Other post owner.");
        Wall.editPostOnTheWall(Wall.getPostId(), RandomUtils.generateString(Config.RANDOM_SIZE));
        Assert.assertEquals(wallForm.getTextPostWall(Config.OWNER_ID), Wall.getTextPostAfterEdit(), "The text isn't random text.");
        Assert.assertNotEquals(wallForm.getTextPostWall(Config.OWNER_ID), Wall.getTextPost(), "The text has not changed.");
        Wall.commitPostWall(Wall.getPostId(), RandomUtils.generateString(Config.RANDOM_SIZE));
        Assert.assertTrue(wallForm.isCommitPostWall(Config.OWNER_ID), "There is no commit.");
        Assert.assertEquals(wallForm.getAuthorCommitPostWall(Config.OWNER_ID), Config.OWNER_ID, "Other commit owner.");
        wallForm.clickLike(Config.OWNER_ID);
        Assert.assertTrue(Likes.isPostLiked(Wall.getPostId()), "There are no likes.");
        Wall.deletePostOnTheWall(Wall.getPostId());
        Assert.assertTrue(wallForm.isDeletePost(Config.OWNER_ID), "The post was not deleted");
    }
}
