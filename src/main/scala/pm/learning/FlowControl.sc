// Flow control
println("Flow control")
// If and expression block
println("If and expression block")
val five = 5
val eight = 8
val expressionBlock = {val sum = five + eight; sum + 7}
val min = if (five < eight) five else eight
// Match
println("Match")
val max = five > eight match {
  case true => five
  case false => eight
}
val maxWithComment = five > eight match {
  case true => {println(s"It's ${five}"); five}
  case false => {println(s"${eight} of course"); eight}
}
val evenOrOdd = 12 match {
  case 2 | 4 | 6 | 8 => "even"
  case 1 | 3 | 5 | 7 | 9 => "odd"
  case _ => "don't know"
}
val fredIsAValueBindingBoundToThingBeingMatched = 12
match {
  case 2 | 4 | 6 | 8 => "even"
  case 1 | 3 | 5 | 7 | 9 => "odd"
  case fred => s"don't know what ${fred} is"
}
val matchWithPatternGuard = 16 match {
  case lowerInt if lowerInt % 2 == 0 => "even"
  case lowerInt => "odd"
}
// Match with pattern variable, matching type - doesn't work - expecting Int
val aString: String = "123"
val anInt: Int = 123
val anAny: Any = 123
val toMatch: Int = 123
//toMatch match {
(123: Int) match {
  case aString => s"${aString} is a String"
  case anInt => s"${anInt} is an Int"
  case anAny => s"${anAny} is an Any"
}
// Example from book - expecting 12180i - does work
val x: Int = 12180
val y: Any = x
y match {
  case x: String => s"'x' is a String"
  case x: Double => f"$x%.2f is a Double"
  case x: Float => f"$x%.2f is a Float"
  case x: Long => s"${x}l is a Long"
  case x: Int => s"${x}i is an Int"
}