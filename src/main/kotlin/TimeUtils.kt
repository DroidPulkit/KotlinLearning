//Top level function and properties
//Notice how this hoursInMillis is just private to this file only
private const val hoursInMillis = 60 * 60 * 1000

//Notice that the internal would make the function as global only to the package we would be in.
//Or in terms of android, the module we are in
internal fun millisForHours(hours: Int) = hours * hoursInMillis


fun Int.convertHoursToMills() : Int
{
    return millisForHours(this)
}

//Extension on generics

fun <T> T.log()
{
    println(this)
}