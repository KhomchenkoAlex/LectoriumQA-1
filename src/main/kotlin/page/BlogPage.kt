package page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import util.AppProperty

class BlogPage(pages: PageManager) : Page(pages) {

    override var pageUrl = AppProperty.getPropertyByName("blog-url")

    @FindBy(xpath = "//div/a/h1" )
    private lateinit var gitHubBlog: WebElement

    fun getElementText(): String = gitHubBlog.text
}