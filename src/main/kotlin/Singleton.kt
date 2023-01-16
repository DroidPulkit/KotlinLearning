
//This is a singleton, only 1 instance of this is active in the memory at a time
object NetworkConfig: NetworkInfoProvider {
    val baseUrl = "http://pulkitkumar.me"
    val userAgent = "demo-app"

    override fun getNetworkDetails(): String {
        return "$baseUrl - $userAgent"
    }
}