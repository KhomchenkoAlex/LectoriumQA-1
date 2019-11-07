import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class LoginTest: BaseTest() {

    private val login = AppProperty.getPropertyByName("login")
    private val password = AppProperty.getPropertyByName("password")
    private val incorrectLogin = AppProperty.getPropertyByName("incorrect-login")
    private val incorrectPassword =  AppProperty.getPropertyByName("incorrect-password")

    @Test
    fun correctLogin(){
        driver.navigate().to(gitHubLoginPage.loginPageUrl)
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS)
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
