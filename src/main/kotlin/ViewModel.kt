import kotlin.properties.Delegates

class ViewModel  {

    //When value of currentQuery changes we call code in the lambda
    var currentQuery: String by Delegates.observable("")
    {
        property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }

    //Use of lazy
    val logger: Logger by lazy {
        println("Init the Logger in ViewModel")
        ApplicationLogger(SimpleLogger())
    }

    fun search(query: String)
    {
        logger.log("query", query)
        currentQuery = query
    }
}