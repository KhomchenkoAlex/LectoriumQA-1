package page

import org.openqa.selenium.WebDriver

open class PageManager (
    val driver: WebDriver
) {
    var blogPage: BlogPage = BlogPage()
    var loginPage: LoginPage = LoginPage()
    var githubPage: GithubPage = GithubPage()
    var customRepositoryPage: CustomRepositoryPage = CustomRepositoryPage()
    var searchResultPage: SearchResultPage = SearchResultPage()
    var userRepositoryPage: UserRepositoriesPage = UserRepositoriesPage()
    var newRepositoryPage: NewRepositoryPage = NewRepositoryPage()

    enum class Pages {
        BLOG_PAGE, CUSTOM_REPOSITORY_PAGE, GITHUB_PAGE, LOGIN_PAGE,
        NEW_REPOSITORY_PAGE, SEARCH_RESULT_PAGE, USER_REPOSITORIES_PAGE
    }
}