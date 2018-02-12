// See Learning Scala ch 2

// Values and variables
println("Values and variables")
println("--------------------")
val multiplier: Double = 9.0 / 5
val offset = 32
val fahrenheitDouble: Double = 13 * multiplier + offset
val fahrenheitInt: Int = (13 * multiplier + offset).toInt
var variable = 1
variable = 2
var convertMe: Int = 128
convertMe.toChar
convertMe.toString
convertMe.toDouble
//convertMe.toChar.toString.toDouble.toInt // gives NumberFormatException
128.toChar

// String formatting and splitting
printf("String formatting and splitting%n")
println("------------------------------")
val debt: Double = 2.738
val interpolated: String = s"You owe $$${debt}!"
val interpolatedAndFormatted = f"You owe $$${debt}%.2f!"
val words = "one two buckle my shoe".split(" ")

val derivativeId = "derivative-id"
val registrationDate = "20171225"
val advertText = "Leather steering wheel, CD sound system"
val body = s"""{
                 "derivativeId": $derivativeId,
                 "registrationDate": $registrationDate,
                 "advertText": $advertText
               }"""
body

// Expression block
println("Expression block")
println("----------------")
val five = 5
val eight = 8
val expressionBlock = {val sum = five + eight; sum + 7}
