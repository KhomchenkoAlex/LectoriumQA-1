import org.testng.Assert
import org.testng.annotations.Test

class LoginTest: BaseTest() {

    val page = GitHubLoginPage(webDriver)

    @Test
    fun correctLogin(){
        page.inputLogin("KhomchenkoAlex")
        page.inputPassword("dozori35")
        page.submit()
        Assert.assertTrue(webDriver.title == "GitHub")
    }

}