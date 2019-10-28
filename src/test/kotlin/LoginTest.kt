import org.openqa.selenium.By
import org.testng.Assert
import org.testng.annotations.Test

class LoginTest : BaseTest() {

    private val login = AppProperty.getPropertyByName("login")
    private val password = AppProperty.getPropertyByName("password")
    private val incorrectLogin = AppProperty.getPropertyByName("incorrect-login")
    private val incorrectPassword =  AppProperty.getPropertyByName("incorrect-password")


    @Test
    fun correctLogin(){
        webDriver.navigate().to(gitHubLoginPage.loginPageUrl)
        gitHubLoginPage.inputLogin(login)
        gitHubLoginPage.inputPassword(password)
        gitHubLoginPage.submit()
        Assert.assertTrue(gitHubLoginPage.successMessage.isEnabled)
    }

    @Test
    fun incorrectLogin() {
        webDriver.navigate().to(gitHubLoginPage.loginPageUrl)
        gitHubLoginPage.inputLogin(incorrectLogin)
        gitHubLoginPage.inputPassword(incorrectPassword)
        gitHubLoginPage.submit()
        Assert.assertTrue(gitHubLoginPage.errorMessage.isEnabled)
    }
}
