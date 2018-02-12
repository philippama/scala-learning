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

case class TestClass(description: String, numThings: Int)
val testClass = TestClass("thing", 0)
testClass.description
testClass.numThings
Seq(
  TestClass("thing-1", 1),
  TestClass("thing-2", 2),
  TestClass("thing-3", 3),
  TestClass("thing-4", 4)
)