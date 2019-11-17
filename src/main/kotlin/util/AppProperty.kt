package util

import java.util.*

object AppProperty {

    private var properties : Properties

    init {
        properties = Properties().apply {
            Thread.currentThread()
                .contextClassLoader
                .getResourceAsStream("application.properties")
                .let {
                    this.load(it)
                }
        }
    }

    fun getPropertyByName(propertyName: String): String? =
        properties.getProperty(propertyName)
}
