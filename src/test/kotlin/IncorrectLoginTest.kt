import org.testng.Assert
import org.testng.annotations.Test

class IncorrectLoginTest: BaseTest() {

    val page = GitHubLoginPage(webDriver)

    @Test
    fun incorrectLogin() {
        page.inputLogin("Incorrect")
        page.inputPassword("password")
        page.submit()
        val errorMessage = webDriver.findElementByXPath("//*[@id=\"js-flash-container\"]")
        Assert.assertTrue(errorMessage.isDisplayed)
    }
}