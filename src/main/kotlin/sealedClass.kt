import kotlin.random.Random

/**
 * Notice how in sealed class, I am restricting type of data to just 3 items Loading, loaded and error
 * But how Loading is just an object, and how Loaded is a data class, and how Error is a normal class
 * and how each of them are extending the UiState class to show that they are part of the sealed class
 */
sealed class UiState {
    // loading
    object Loading: UiState()

    //loaded
    data class Loaded(val title: String, val subtitle: String): UiState()

    //error
    class Error(val error: Throwable): UiState()
}

fun render(uiState: UiState) = when(uiState) {
    is UiState.Error -> println("Oh no error")
    is UiState.Loaded -> println("Loaded: ${uiState.title}")
    UiState.Loading -> println("Loading")
}

sealed class StringResult {
    data class Success(val data: String): StringResult()
    class Error(val error: Throwable): StringResult()
}

fun getString() : StringResult
{
    return try {
        StringResult.Success(getRandomString())
    } catch (exception: java.lang.IllegalArgumentException)
    {
        StringResult.Error(exception)
    }
}

fun getRandomString(): String {
    val random = Random.nextInt(10)
    return if (random > 5) throw IllegalArgumentException()
    else random.toString()
}