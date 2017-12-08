"Case classes are good for DTOs"

case class Person(firstName: String, lastName: String)

val elizabeth = Person("Elizabeth", "Bennett")
val another = elizabeth.copy()
val jane = elizabeth.copy("Jane")
val married = elizabeth.copy(lastName = "Darcy")
elizabeth == another
elizabeth equals another
elizabeth == jane
elizabeth == null

jane match {
//elizabeth match {
    case Person("Elizabeth", surname) => s"Eliza $surname"
    case Person(other, surname) => s"$other $surname"
}
