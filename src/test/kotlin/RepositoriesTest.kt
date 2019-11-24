import org.testng.Assert
import org.testng.annotations.Test

class RepositoriesTest: BaseTest() {
    private val repoPage = pageManager.userRepositoryPage
    private val githubPage = pageManager.githubPage

    @Test
    fun repositoryTest() {
        navigationHelper.navigateTo(githubPage)
        navigationHelper.goToYourRepositories()
        Assert.assertTrue(getCurrentUrl().contains("repositories", ignoreCase = true))
        Assert.assertTrue(repoPage.repositoryList.isNotEmpty())
    }

    @Test
    fun repositoryFindTest() {
        val searchText = repositoryHelper.getTextForSearch()
        repositoryHelper.insertTextToSearchField(searchText)
        val resultList = repositoryHelper.getSearchResults()
        val names = repositoryHelper.getRepositoriesNameList(resultList)
        Assert.assertTrue(resultList.isNotEmpty())
        Assert.assertTrue(names.all { it.contains(searchText, ignoreCase = true) })
    }

    @Test
    fun createNewRepositoryTest(){
        navigationHelper.navigateTo(githubPage)
        repositoryHelper.createNewRepository("Test")
        navigationHelper.goToYourRepositories()
        val repoNames = repositoryHelper.getAllRepositoryNamesList()
        Assert.assertTrue(repoNames.contains("Test"))
    }

}