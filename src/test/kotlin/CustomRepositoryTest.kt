import org.testng.Assert
import org.testng.annotations.Test

class CustomRepositoryTest: BaseTest() {

    private val repoPage = pageManager.customRepositoryPage
    private val githubPage = pageManager.githubPage

    @Test
    fun checkAllElementsNumber() {
        navigationHelper.navigateTo(githubPage)
        userHelper.clickOnRepositoryLink()
        Assert.assertEquals(repositoryHelper.getAllElementsCount(), 7)
    }

    @Test
    fun checkFilesAndDirectoriesCount(){
        val filesCount = repositoryHelper.getFilesCount()
        val directoriesCount = repositoryHelper.getDirectoriesCount()
        val allElements = repositoryHelper.getAllElementsCount()
        Assert.assertEquals(directoriesCount, 2)
        Assert.assertEquals(filesCount, 5)
        Assert.assertEquals(allElements, (directoriesCount + filesCount))
    }
}