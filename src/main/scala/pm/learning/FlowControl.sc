// See Learning Scala ch 3

// Flow control
println("Flow control")
println("============")

// If and expression block
println("If and expression block")
println("-----------------------")
val five = 5
val eight = 8
val expressionBlock = {val sum = five + eight; sum + 7}
val min = if (five < eight) five else eight

// Match - match...case
println("Match - match...case")
println("--------------------")
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
val matchWithPatternGuard = 17 match {
  case lowerInt if lowerInt % 2 == 0 => "even"
  case lowerInt => "odd"
}

def whatAmI(mysteryVariable: Any): String = {
  mysteryVariable match {
    case null => "I am null."
    case 57 => "I am Heinz."
    case x: String => s"I am a String. I am '$x'."
    case x: Boolean => s"I am a Boolean. I am '$x'."
    case x: Double => s"I am a Double. I am '$x'."
    case x: Float => s"I am a Float. I am '$x'."
    case x: Int => s"I am an Int. I am '$x'."
    case x: Any => s"I am an Any. I am '$x, ${x.getClass}."
    case _ => s"I have little self-awareness. I am '$x', ${x.getClass}."
  }
}
whatAmI(null)
whatAmI("superwoman")
whatAmI(57)
whatAmI(563007)
whatAmI(563007.toDouble)
whatAmI(true)
whatAmI(3.1415926)
whatAmI(3.1415926.toFloat)
whatAmI(13.toByte)
val any: Any = "superman"
whatAmI(any)
