package helper

import org.openqa.selenium.WebDriver
import page.PageManager
import page.PageManager.Pages.*

class NavigationHelper(driver: WebDriver): PageManager(driver) {

    fun getPageUrl(page: Pages) = when (page) {
        BLOG_PAGE -> blogPage.pageUrl
        CUSTOM_REPOSITORY_PAGE -> customRepositoryPage.pageUrl
        GITHUB_PAGE -> githubPage.pageUrl
        LOGIN_PAGE -> loginPage.pageUrl
        NEW_REPOSITORY_PAGE -> newRepositoryPage.pageUrl
        SEARCH_RESULT_PAGE -> searchResultPage.pageUrl
        USER_REPOSITORIES_PAGE -> userRepositoryPage.pageUrl
    }

    fun navigateTo(page: Pages) = driver.navigate().to(getPageUrl(page))

    fun goToYourRepositories(){
        githubPage.clickOnAvatarIcon()
        githubPage.clickOnYourRepositories()
    }
}