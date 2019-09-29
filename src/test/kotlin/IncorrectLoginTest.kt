import org.testng.Assert
import org.testng.annotations.Test

class IncorrectLoginTest: BaseTest() {

    val page = GitHubLoginPage(webDriver)

    val login = "IncorrectLogin"
    val password = "IncorrectPassword"

    @Test
    fun incorrectLogin() {
        page.inputLogin(login)
        page.inputPassword(password)
        page.submit()
        val errorMessage = webDriver.findElementByXPath("//*[@id=\"js-flash-container\"]")
        Assert.assertTrue(errorMessage.isDisplayed)
    }
}