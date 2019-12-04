package helper

import org.openqa.selenium.WebDriver

import page.PageManager

class WebElementHelper(driver: WebDriver): PageManager(driver) {

    fun getBlogElementText() = blogPage.getElementText()
    fun getLoginSuccessMessage() = loginPage.successMessage
    fun getLoginErrorMessage() = loginPage.errorMessage
    fun isSignInIsVisible() = githubPage.isSignInVisible()
}