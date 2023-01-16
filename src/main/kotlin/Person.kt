/**
 * To extend add open
 */
open class Person(
     age: Int,
     protected val firstName: String,
     protected val lastName: String)
 {
     init {
         //Neat way to do validation of constructor items
         check(age > 0) {
             "A person's age cannot be less than 0"
         }
     }

     val age: Int = age

     //To override add open
     open fun printName() = println("$firstName $lastName")
}