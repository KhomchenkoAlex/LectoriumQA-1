package page

import WebDriverInitializer
import org.openqa.selenium.support.PageFactory

open class PageObject {

    init {
        PageFactory.initElements(WebDriverInitializer.webDriver, this)
    }
}