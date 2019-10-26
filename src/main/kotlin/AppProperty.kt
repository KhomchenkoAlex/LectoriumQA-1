import java.util.*

object AppProperty {
    private val properties = Properties().apply {
        Thread.currentThread()
            .contextClassLoader
            .getResourceAsStream("application.properties")
            .let {
                this.load(it)
            }
    }

    fun getPropertyByName(propertyName: String): String? =
        properties.getProperty(propertyName)
}
