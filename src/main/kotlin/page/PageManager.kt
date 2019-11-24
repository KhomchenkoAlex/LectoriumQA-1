package page

import org.openqa.selenium.WebDriver

open class PageManager (
    val driver: WebDriver
) {
    var blogPage: BlogPage = BlogPage(this)
    var loginPage: LoginPage = LoginPage(this)
    var githubPage: GithubPage = GithubPage(this)
    var customRepositoryPage: CustomRepositoryPage = CustomRepositoryPage(this)
    var searchResultPage: SearchResultPage = SearchResultPage(this)
    var userRepositoryPage: UserRepositoriesPage = UserRepositoriesPage((this))
    var newRepositoryPage: NewRepositoryPage = NewRepositoryPage(this)
}