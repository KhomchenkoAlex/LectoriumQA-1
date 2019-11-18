import org.testng.Assert
import org.testng.annotations.Test

class LogoutTest: BaseTest() {
    private val page = pageManager.githubPage

    @Test
    fun logoutTest(){
        navigationHelper.navigateTo(page)
        userHelper.signOut()
        Assert.assertTrue(page.isSignInVisible())
    }
}