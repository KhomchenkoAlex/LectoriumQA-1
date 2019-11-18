package page

import manager.AppManager
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

abstract class Page(
    pages: PageManager
) {
    private val driver = AppManager.webDriver
    var wait: WebDriverWait = WebDriverWait(driver, 10)
    var shortWait: WebDriverWait = WebDriverWait(driver, 3)
    val waitTimeout: (Long) -> Unit = { time: Long -> wait.withTimeout(Duration.ofSeconds(time))}

    open var pageUrl: String? = null

    init {
        PageFactory.initElements(driver, this)
    }
}
