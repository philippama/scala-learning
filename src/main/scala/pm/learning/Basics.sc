// Values and variables
printf("Values and variables%n")
val multiplier: Double = 9.0 / 5
val offset = 32
val fahrenheitDouble: Double = 13 * multiplier + offset
val fahrenheitInt: Int = (13 * multiplier + offset).toInt
var variable = 1
variable = 2

// String formatting and splitting
printf("String formatting and splitting%n")
val debt: Double = 2.738
val interpolated: String = s"You owe $$${debt}!"
val interpolatedAndFormatted = f"You owe $$${debt}%.2f!"
val words = "one two buckle my shoe".split(" ")

// Expression block
println("Expression block")
val five = 5
val eight = 8
val expressionBlock = {val sum = five + eight; sum + 7}
