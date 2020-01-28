import org.testng.Assert
import org.testng.annotations.Test

class AboutTest: BaseTest() {

    @Test
    fun aboutTest() {
        userHelper.clickOnAboutLink()
        userHelper.clickOnTwitter()
        val currentUrl = userHelper.getCurrentUrl()
        println(currentUrl)
        val text = userHelper.geGitHubLinkText()
        println(text)
        Assert.assertTrue(text == "GitHub")
        Assert.assertTrue(userHelper.isAccountVerifiedElementVisible())
        Assert.assertTrue(currentUrl.contains("twitter.com", ignoreCase = true))
    }
}