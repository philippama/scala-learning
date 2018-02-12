import scala.annotation.tailrec

// def <identifier>(<identifier>: <type>[, ... ]): <type> = <expression>
def inputlessFunction = "Inputless function"
inputlessFunction
def inputlessFunctionWithType : String = "Declaring the return type is optional"
inputlessFunctionWithType
// Parentheses
def inputlessFunctionWithParentheses(): String = "Inputless function with empty parentheses"
inputlessFunctionWithParentheses
inputlessFunctionWithParentheses()
//inputlessFunction() // Not allowed to call with parentheses if declared without them

// Return values
def safeTrim(string: String): String = {
  if (string == null) {
    return null
  }
  string.trim; // The last line is the return value
}

def aProcedure: Unit = print("A procedure is a function that doesn't return anything")
aProcedure

"Parameters"
"----------"

def functionWithParameter(message1: String) = {
  "message is: " + message1
}
def functionWithParameter(message1: String, message2: String) = {
  "message is: " + message1 + " " + message2
}
functionWithParameter("hello", "world")
functionWithParameter {val firstBit: String = "Parameter is "; firstBit + "an expression"}
functionWithParameter(message2 = "parameters", message1 = "named")
def functionWithDefaultValue(message1: String = "hello", message2: String): String = {
  "message is: " + message1 + " " + message2
}
functionWithDefaultValue(message2 = "could be the default value")

def varArgParameters(words: String*) = {
  var sentence: String = ""
  for (word <- words) {
    sentence = sentence + word + " "
  }
  sentence
}
varArgParameters("The", "boy", "stood", "on", "the", "burning", "deck")
val secondLine = List("whence", "all", "but", "he", "had", "fled")
varArgParameters(secondLine: _*)

// Also parameter groups
// Type parameters are like Java generics
println("Type parameters")
def identity[A](a: A): A = a
identity("a string parameter")
identity(12)

"Recursion"
"---------"

def factorial(number: Int, total: Int): Int = {
  if (number > 1) {
    factorial(number - 1, total * number)
  }
  else total
}
factorial(3, 1)

@tailrec
def factorialWithTailRecursion(number: Int, total: Int): Int = {
  if (number > 1) {
    factorialWithTailRecursion(number - 1, total * number)
  }
  else total
}
factorialWithTailRecursion(3, 1)
// !!! should be a compilation error here because recursive call is not last in function !!!
// It doesn't give an error from the scala console. However,
// this from the book does (uncomment @annotation.tailrec):
//@annotation.tailrec
def power(x: Int, n: Int): Long = {
  if (n < 1) 1
  else x * power(x, n - 1)
}


"Nested functions"
"----------------"

def outerFunction() = {
  def innerFunction(x: Int): Int = {x + 2}
  println("Result from inner function = " + innerFunction(3))
}
outerFunction()

