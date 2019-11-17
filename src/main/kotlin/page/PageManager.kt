package page

import org.openqa.selenium.WebDriver

open class PageManager (
    val driver: WebDriver
) {
    var blogPage: BlogPage = BlogPage(this)
    var loginPage: LoginPage = LoginPage(this)
    var githubPage: GithubPage = GithubPage(this)
    var repositoryPage: RepositoryPage = RepositoryPage(this)
    var searchResultPage: SearchResultPage = SearchResultPage(this)

    fun navigateTo(page: Page) = driver.navigate().to(page.pageUrl)
   
}