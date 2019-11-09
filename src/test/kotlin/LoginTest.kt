import extension.waitForPageLoad
import org.testng.Assert
import org.testng.annotations.Test

class LoginTest: BaseTest() {

    private val login = AppProperty.getPropertyByName("login")
    private val password = AppProperty.getPropertyByName("password")
    private val incorrectLogin = AppProperty.getPropertyByName("incorrect-login")
    private val incorrectPassword =  AppProperty.getPropertyByName("incorrect-password")

    @Test
    fun correctLogin(){
        driver.navigate().to(gitHubLoginPage.loginPageUrl)
        driver.waitForPageLoad(3)
        gitHubLoginPage.inputLogin(login)
        gitHubLoginPage.inputPassword(password)
        gitHubLoginPage.submit()
        Assert.assertTrue(gitHubLoginPage.successMessage.isEnabled)
    }

    @Test
    fun incorrectLogin() {
        driver.navigate().to(gitHubLoginPage.loginPageUrl)
        gitHubLoginPage.inputLogin(incorrectLogin)
        gitHubLoginPage.inputPassword(incorrectPassword)
        gitHubLoginPage.submit()
        Assert.assertTrue(gitHubLoginPage.errorMessage.isEnabled)
    }
}
