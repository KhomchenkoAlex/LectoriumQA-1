import org.testng.Assert
import org.testng.annotations.Test

class LoginTest: BaseTest() {

    private val loginPage = pageManager.loginPage

    @Test
    fun correctLogin(){
        navigationHelper.navigateTo(loginPage)
        userHelper.correctLogin()
        Assert.assertTrue(loginPage.successMessage.isEnabled)
    }

    @Test
    fun incorrectLogin() {
        navigationHelper.navigateTo(loginPage)
        userHelper.incorrectLogin()
        Assert.assertTrue(loginPage.errorMessage.isEnabled)
    }
}
