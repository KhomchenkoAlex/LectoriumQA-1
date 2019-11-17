package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.WebDriverWait

abstract class Page(
    pages: PageManager
) {
    var driver: WebDriver = pages.driver
    var wait: WebDriverWait = WebDriverWait(driver, 10)
    var shortWait: WebDriverWait = WebDriverWait(driver, 3)

    open var pageUrl: String? = null

    init {
        PageFactory.initElements(driver, this)
    }
}
