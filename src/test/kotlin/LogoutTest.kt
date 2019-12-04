import org.testng.Assert
import org.testng.annotations.Test
import page.PageManager.Pages.GITHUB_PAGE

class LogoutTest: BaseTest() {

    @Test
    fun logoutTest(){
        navigationHelper.navigateTo(GITHUB_PAGE)
        userHelper.signOut()
        Assert.assertTrue(webElementHelper.isSignInIsVisible())
    }
}