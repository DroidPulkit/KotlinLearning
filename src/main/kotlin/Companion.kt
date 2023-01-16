
class SearchController {
    private var query: String = ""

    init {
        MAX_RESULTS
    }

    companion object {

        private const val MAX_RESULTS = 20

        fun create(initialQuery: String) : SearchController
        {
            return SearchController().also {
                //Notice how the companion object can access the private variable of the class
                it.query = initialQuery
            }
        }
    }
}