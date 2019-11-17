import org.testng.Assert
import org.testng.annotations.Test

class RepositoriesTest: BaseTest() {
    private val repoPage = pageManager.userRepositoryPage
    private val githubPage = pageManager.githubPage

    @Test
    fun repositoryTest() {
        pageManager.navigateTo(githubPage)
        githubPage.clickToYourRepositories()
        Assert.assertTrue(driver.currentUrl.contains("repositories", ignoreCase = true))
        Assert.assertTrue(repoPage.repositoryList.isNotEmpty())
    }

    @Test
    fun repositoryFindTest() {
        val randomRepoName = repoPage.getRandomRepositoryName(repoPage.repositoryList).slice(0..1)
        repoPage.insertTextIntoFindRepositoryInput(randomRepoName)
        val resultList = repoPage.refreshedRepositoryList()
        val result = repoPage.getResultRepositoryNames(resultList)
        Assert.assertTrue(result.isNotEmpty())
        Assert.assertTrue(result.all { it.contains(randomRepoName, ignoreCase = true) })
    }

}