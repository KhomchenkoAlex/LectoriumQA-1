package extension

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

fun ChromeDriver.waitForPageLoad(duration: Long): WebDriver.Timeouts =
    this.manage().timeouts().pageLoadTimeout(duration, TimeUnit.SECONDS)

fun ChromeDriver.implicitlyWait(duration: Long): WebDriver.Timeouts
        = this.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS)