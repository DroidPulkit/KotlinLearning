import kotlinx.coroutines.*
import java.lang.IllegalStateException
import java.util.concurrent.Executors

fun main() {

    //----------------
    //Classes
    //Can have datatype as parent class, and write object as child class
    val student: Person = Student(25, "Pulkit", "Kumar")
    student.printName()


    //------------------
    //Interface
    val someVariable: DefaultStringProvider? = null
    if (someVariable is StringProvider)
    {
        println("Some variable is a StringProvider")
    }

    var stringProvider : StringProvider = DefaultStringProvider()
    println(stringProvider.getString(5))
    println(stringProvider.placeholder)

    //------------------
    //Enums

    val direction: Direction = Direction.SOUTH
    println(direction.name)
    println(direction.ordinal)
    //Main thing is to convert string to enums. how?
    //Error-prone as it gives IllegalArgumentException and
    // also why does the letter casing have to be same?
    val parsedDirection = Direction.valueOf("north".uppercase())
    println(parsedDirection.name)

    //List all values in enum
    val listOfDirections = Direction.values()
    listOfDirections.iterator().forEach { println(it) }

    val color = HighlightColor.BLUE
    println(color.value)

    //------------------
    //Data classes

    val task1 = Task(1,"Task 1")
    val task2 = Task(2,"Task 2")

    println(task1.name)
    println(task2.name)

    if (task1.name == task2.name) println("Task are same")
    else println("Task are not same")

    //best way to check if data is same
    val task3 = Task(3,"Task 3")
    val task4 = Task(3,"Task 3")
    if (task3 == task4) println("Task are same")
    else println("Task are not same")

    val task3Copy = task3.copy(id = 4)
    if (task3 == task3Copy) println("Task are same")
    else println("Task are not same")

    //new thing
    //destructing: values to the variable are assigned in the order of variable of data class
    val (id, name) = task1

    //-----------------
    //Singleton
    println(NetworkConfig.baseUrl)
    println(NetworkConfig.getNetworkDetails())

    //Quick and anonymous way to implement the interface
    val provider : NetworkInfoProvider = object: NetworkInfoProvider {
        override fun getNetworkDetails(): String {
            return "Yo"
        }
    }
    println(provider.getNetworkDetails())

    //-----------------
    //Sealed classes
    //Similar to enum in terms of defining restricted type hierarchy,
    // but provides extra/different properties per member
    //This brings freedom to model our data in whatever way we want, but then restrict to that way only

    var state: UiState = UiState.Loading
    render(state)
    state = UiState.Loaded("Kotlin", "is fun eh!")
    render(state)
    state = UiState.Error(IllegalStateException())
    render(state)


    //-----------------
    //Companion objects
    //kotlin doesn't have static, so we use companion objects
    val searchController = SearchController.create("Toronto")

    //------------------
    //Challenge
    //Rerun the app, to see different response
    when(val getStringDataFromNetwork = getString())
    {
        is StringResult.Error -> println("Oh no an error from network ${getStringDataFromNetwork.error}")
        is StringResult.Success -> println("Success in getting data from network: ${getStringDataFromNetwork.data}")
    }

    //-------------------
    //Top level properties and functions
    //See below for it
    //Not a good thing to have top level properties and functions
    //Look into TimeUtils.kt file
    println("Top level function: ${millisForHours(10)}")

    //---------------------
    //Extension functions

    println("Extension function: ${5.convertHoursToMills()}")
    println("Extension function (Generics):")
    listOf(1,2,3).log()

    //---------------------
    //Delegation

    val applicationLogger = ApplicationLogger(SimpleLogger())
    applicationLogger.log("Delegation", "This is how delegation works")

    println("ViewModel about to be created")
    val viewModel = ViewModel()
    println("ViewModel created \nSearch func in viewmodel is about to be called")
    viewModel.search("Kotlin")
    println("Search function call finished")
    viewModel.search("Java")

    //Challenge
    //ListUtils.nonEmptyList(arrayListOf(1,2,3))
    //ListUtils.setToNonEmptyList(setOf("a", "b", "c"))

    arrayListOf(1,2,3).toNonEmptyList().also {
        println(it)
    }

    setOf("a", "b", "c").toNonEmptyList().also {
        println(it)
    }

    //---------------------
    //Threads, thread pool and executors

    CustomThread().start()
    println(Thread.currentThread().name)

    //Custom runnable
    Thread(CustomRunnable()).start()

    //ThreadPools
    //Not a good thing to create raw threads in production, as made above
    executor.submit(CustomRunnable())
    for (i in 0..10) {
        multiThreadExecutor.submit(
            CustomRunnable()
        )
    }

    //---------------------
    //Coroutines
    //See refresh_home.kt
    GlobalScope.launch { println("Hello from coroutines") }

    runBlocking {
        GlobalScope.launch { println("Hello from coroutines inside the run blocking") }
    }

    //Challenge
    runBlocking {
        val loadDataFromDb = async { loadItemsFromDB() }
        val loadDataFromNetwork = async { loadItemsFromNetwork() }
        val data = loadDataFromDb.await() + loadDataFromNetwork.await()
        withContext(this@runBlocking.coroutineContext) {
            println(data)
        }
    }
}

val executor = Executors.newSingleThreadExecutor()
val multiThreadExecutor = Executors.newFixedThreadPool(3)

//Top level property
const val DEFAULT_CLICK_VALUE = 1200

//Top level function
fun sum(a: Int, b: Int): Int
{
    return a+b
}

private suspend fun loadItemsFromDB(): List<String> {
    delay(5000)
    return listOf("Kotlin", "Java", "C#")
}

private suspend fun loadItemsFromNetwork(): List<String> {
    delay(5000)
    return listOf("Rust", "Python", "C")
}