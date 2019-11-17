import extension.waitForPageLoad
import org.testng.Assert
import org.testng.annotations.Test

class LogoutTest: BaseTest() {
    private val page = pageManager.githubPage

    @Test
    fun logoutTest(){
        pageManager.navigateTo(page)
        driver.waitForPageLoad(3)
        userHelper.signOut()
        Assert.assertTrue(page.isSignInVisible())
    }
}