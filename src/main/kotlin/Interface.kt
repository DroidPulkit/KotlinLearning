interface StringProvider
{
    //cannot give default value to properties of interface
    val placeholder: String

    //Can give default value to the method of interface
    fun getString(id: Int): String = id.toString()
}

//Class extending interface
class DefaultStringProvider: ResourceProvider
{
    override val placeholder: String = "Some placeholder"
}

//Interface extending another interface
interface ResourceProvider : StringProvider {
    fun getDimension(id: Int): Long = id.toLong()
}