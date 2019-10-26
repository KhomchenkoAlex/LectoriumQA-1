import org.testng.Assert
import org.testng.annotations.Test

class LoginTest : BaseTest() {

    private val page = GitHubLoginPage(webDriver)

    private val login = AppProperty.getPropertyByName("login")
    private val password = AppProperty.getPropertyByName("password")
    private val incorrectLogin = AppProperty.getPropertyByName("incorrect-login")
    private val incorrectPassword =  AppProperty.getPropertyByName("incorrect-password")

    private val successMessageLocator = "//a[contains(text(),'Signed in as')]"
    private val errorMessageLocator = "//form/div/div[contains(., 'Incorrect')]"


    @Test
    fun correctLogin(){
        webDriver.navigate().to(page.loginPageUrl)
        page.inputLogin(login)
        page.inputPassword(password)
        page.submit()
        val successMessage = webDriver.findElementByXPath(successMessageLocator)
        Assert.assertTrue(successMessage.isEnabled)
    }

    @Test
    fun incorrectLogin() {
        webDriver.navigate().to(page.loginPageUrl)
        page.inputLogin(incorrectLogin)
        page.inputPassword(incorrectPassword)
        page.submit()
        val errorMessage = webDriver.findElementByXPath(errorMessageLocator)
        Assert.assertTrue(errorMessage.isEnabled)
    }
}
