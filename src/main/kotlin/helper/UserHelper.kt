package helper

import org.openqa.selenium.WebDriver
import page.PageManager
import util.AppProperty

class UserHelper(driver: WebDriver): PageManager(driver) {

    private val login = AppProperty.getPropertyByName("login")
    private val password = AppProperty.getPropertyByName("password")
    private val incorrectLogin = AppProperty.getPropertyByName("incorrect-login")
    private val incorrectPassword =  AppProperty.getPropertyByName("incorrect-password")


    fun loginAs(){}

    fun signOut(){
        githubPage.clickOnAvatarIcon()
        githubPage.clickOnSignOut()
    }

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

    fun searchFor(text: String) {
        githubPage.inputIntoSearch(text)
        githubPage.clickOnAllGithubButton()
    }

    fun clickOnRepositoryLink(){
        githubPage.clickOnRepositoryListElement()
    }



}