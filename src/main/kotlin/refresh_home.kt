import kotlinx.coroutines.*

private suspend fun refreshTasks() {
    delay(3000)
    println("Refreshing tasks on ${Thread.currentThread().name}")
}
private suspend fun refreshReservations() {
    delay(3000)
    println("Refreshing reservations on ${Thread.currentThread().name}")
}
private fun refreshUser() {
    println("Refreshing user on ${Thread.currentThread().name}")
}
private fun updateUI() {
    println("Updating UI on ${Thread.currentThread().name}")
}

private fun cancelEverything(vararg jobs: Job) {
    jobs.forEach { it.cancel() }
}

fun main(): Unit = runBlocking {
    val task = async { refreshTasks() }
    val reservations = async { refreshReservations() }

    awaitAll(task, reservations)

    withContext(this@runBlocking.coroutineContext){
        updateUI()
    }

    //To cancel the coroutines
    val job = launch { refreshUser() }
    job.cancel()
}