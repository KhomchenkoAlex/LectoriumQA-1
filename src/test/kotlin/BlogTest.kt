import org.testng.Assert
import org.testng.annotations.Test

class BlogTest: BaseTest() {

    private val blogUrl = AppProperty.getPropertyByName("blog-url").toString()

    @Test
    fun blogTest() {
        githubPage.clickOnBlog()
        val currentUrl = driver.currentUrl as String
        Assert.assertTrue(currentUrl.contentEquals(blogUrl))
        Assert.assertEquals(blogPage.getElementText(), "The GitHub Blog")
    }
}