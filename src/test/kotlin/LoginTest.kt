import extension.waitForPageLoad
import org.testng.Assert
import org.testng.annotations.Test

class LoginTest: BaseTest() {

    private val loginPage = pageManager.loginPage

    @Test
    fun correctLogin(){
        pageManager.navigateTo(loginPage)
        driver.waitForPageLoad(3)
        userHelper.correctLogin()
        Assert.assertTrue(loginPage.successMessage.isEnabled)
    }

    @Test
    fun incorrectLogin() {
        pageManager.navigateTo(loginPage)
        driver.waitForPageLoad(3)
        userHelper.incorrectLogin()
        Assert.assertTrue(loginPage.errorMessage.isEnabled)
    }
}
