package helper

import org.openqa.selenium.WebDriver
import page.Page
import page.PageManager

class NavigationHelper(driver: WebDriver): PageManager(driver) {

    fun navigateTo(page: Page) = driver.navigate().to(page.pageUrl)

    fun goToYourRepositories(){
        githubPage.clickOnAvatarIcon()
        githubPage.clickOnYourRepositories()
    }
}