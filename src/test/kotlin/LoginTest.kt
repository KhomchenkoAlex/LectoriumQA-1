import org.testng.Assert
import org.testng.annotations.Test
import page.PageManager.Pages.LOGIN_PAGE

class LoginTest: BaseTest() {

    @Test
    fun correctLogin(){
        navigationHelper.navigateTo(LOGIN_PAGE)
        userHelper.correctLogin()
        Assert.assertTrue(webElementHelper.getLoginSuccessMessage().isEnabled)
    }

    @Test
    fun incorrectLogin() {
        navigationHelper.navigateTo(LOGIN_PAGE)
        userHelper.incorrectLogin()
        Assert.assertTrue(webElementHelper.getLoginErrorMessage().isEnabled)
    }
}
