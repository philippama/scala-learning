"Tuples"
"------"

("first", "second")
("first", "second", "third")
("first", "second", "third")._1
("first", "second", "third")._2
("first", "second", "third")._3

val (premier, deuxieme, troisieme) = ("first", "second", "third")
premier
deuxieme
troisieme

"Enumeration"
"-----------"
// See also Traits.sc
object Direction extends Enumeration {
  type Direction = Value
  val NORTH, EAST, SOUTH, WEST = Value

  def fromVersion(s: String): Value = {
    val version = values.find(_.toString == s)
    version match {
      case Some(value) => value
      case None => throw new IllegalArgumentException(s"Bad version $s")
    }
  }
}

println("hello")

println(s"East is ${Direction.EAST}")

val direction = Direction.NORTH
println(direction.toString)
Direction.values.foreach(println)

val validDirection = Direction.fromVersion("WEST")
println(s"Go $validDirection")

//val invalidDirection = Direction.fromVersion("blah") // Get IllegalArgumentException

"Exceptions"
"----------"
try {
  throw new IllegalArgumentException("That was bad")
}
catch {
  case _: IllegalArgumentException => println("Try another argument")
  case e: Exception => println(s"${e.getMessage}")
}

"Other"
"-----"

classOf[String].getMethods.map(_.getName)
