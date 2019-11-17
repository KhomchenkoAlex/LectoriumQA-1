import org.testng.Assert
import org.testng.annotations.Test

class BlogTest : BaseTest() {

    private val blogPage = pageManager.blogPage

    @Test
    fun blogTest() {
        userHelper.goToBlog()
        val currentUrl = driver.currentUrl as String
        Assert.assertTrue(currentUrl.contentEquals(blogPage.pageUrl!!))
        Assert.assertEquals(blogPage.getElementText(), "The GitHub Blog")
    }
}