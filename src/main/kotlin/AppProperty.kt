
import java.io.FileInputStream
import java.util.*

object AppProperty {
    private val inputStream =
        FileInputStream( System.getProperty("user.dir") + "/src/test/resources/application.properties")
    private val properties = Properties().also {
        it.load(inputStream)
    }

    fun getProperty(propertyName: String): String? =
        properties.getProperty(propertyName)
}