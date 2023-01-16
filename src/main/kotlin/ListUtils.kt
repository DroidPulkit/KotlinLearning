
//Challenge
//class ListUtils {
//    companion object {
//        fun <T> nonEmptyList(vararg items: T): List<T> {
//            check(items.isNotEmpty())
//            {
//                "NonEmptyList must have at least one item"
//            }
//            return items.toList()
//        }
//
//        fun <T> setToNonEmptyList(set: Set<T>): List<T>
//        {
//            check(set.isNotEmpty())
//            {
//                "NonEmptyList must have at least one item"
//            }
//            return set.toList()
//        }
//    }
//}

//Solution
fun <T> ArrayList<T>.toNonEmptyList() : List<T> {
    check(this.isNotEmpty())
    {
        "NonEmptyList must have at least one item"
    }
    return this.toList()
}

fun <T> Set<T>.toNonEmptyList(): List<T>
{
    check(this.isNotEmpty())
    {
        "NonEmptyList must have at least one item"
    }
    return this.toList()
}