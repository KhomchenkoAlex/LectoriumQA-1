import org.testng.Assert
import org.testng.annotations.Test
import page.RepositoryPage
import java.util.concurrent.TimeUnit

class RepositoryTest: BaseTest() {

    @Test
    fun repositoryTest() {
        githubPage.clickOnRepositoryListElement()
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS)
        Assert.assertEquals(repoPage.getRepositoryElementsNumber(), 7)
    }
}