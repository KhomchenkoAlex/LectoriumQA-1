package helper

import io.qameta.allure.Step
import org.openqa.selenium.WebDriver
import page.PageManager
import util.AppProperty

class UserHelper(driver: WebDriver): PageManager(driver) {

    private val login = AppProperty.getPropertyByName("login")
    private val password = AppProperty.getPropertyByName("password")
    private val incorrectLogin = AppProperty.getPropertyByName("incorrect-login")
    private val incorrectPassword =  AppProperty.getPropertyByName("incorrect-password")


    fun loginAs(){}

    @Step("Sign out")
    fun signOut(){
        githubPage.clickOnAvatarIcon()
        githubPage.clickOnSignOut()
    }

    @Step("Successful Login")
    fun correctLogin(){
        loginPage.inputLogin(login)
        loginPage.inputPassword(password)
        loginPage.submit()
    }
    
    fun incorrectLogin(){
        loginPage.inputLogin(incorrectLogin)
        loginPage.inputPassword(incorrectPassword)
        loginPage.submit()
    }

    fun clickOnBlogLink(){
        githubPage.clickOnBlog()
    }

    fun clickOnAboutLink(){
        githubPage.clickOnAbout()
    }

    fun clickOnTwitter() {
        aboutPage.getTwitterButton().click()
    }

    fun getCurrentUrl(): String {
        return driver.currentUrl.toLowerCase()
    }

    fun searchFor(text: String) {
        githubPage.inputIntoSearch(text)
        githubPage.clickOnAllGithubButton()
    }

    fun clickOnRepositoryLink(){
        githubPage.clickOnRepositoryListElement()
    }

    fun geGitHubLinkText(): String {
       return twitterPage.getGitHubLink().text
    }

    fun isAccountVerifiedElementVisible(): Boolean {
        return twitterPage.getAccountVerifiedElement().isDisplayed
    }



}