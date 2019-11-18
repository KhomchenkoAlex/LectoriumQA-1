import org.testng.Assert
import org.testng.annotations.Test

class CustomRepositoryTest: BaseTest() {

    private val repoPage = pageManager.customRepositoryPage
    private val githubPage = pageManager.githubPage

    @Test
    fun checkAllElementsNumber() {
        navigationHelper.navigateTo(githubPage)
        userHelper.goToRepository()
        Assert.assertEquals(repoPage.getAllRepositoryElementsNumber(), 7)
    }

    @Test
    fun checkFilesAndDirectoriesCount(){
        val filesCount = repoPage.getFileElementsNumber()
        val directoriesCount = repoPage.getDirectoryElementsNumber()
        val allElements = repoPage.getAllRepositoryElementsNumber()
        Assert.assertEquals(directoriesCount, 2)
        Assert.assertEquals(filesCount, 5)
        Assert.assertEquals(allElements, (directoriesCount + filesCount))
    }
}