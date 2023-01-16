//Thread with custom name
class CustomThread: Thread("CustomThread")
{
    override fun run() {
        super.run()
        println("CustomThread.run()")
        println(Thread.currentThread().name)
    }
}

class CustomRunnable: Runnable
{
    override fun run() {
        println("CustomRunnable.run()")
        println(Thread.currentThread().name)
    }

}