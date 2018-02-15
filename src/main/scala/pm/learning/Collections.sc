import scala.collection.SortedMap
// See Learning Scala ch 6

"-" * 11
"-- Lists --"
"-" * 11

"List is an immutable linked list."

val exclusiveRange = 1 until 5
val inclusiveRange = 1 to 5
List.fill(3) (Math.random())

"Building a list"
val primaryColours = List("red", "green", "blue")
val secondaryColours = "yellow" :: "cyan" :: "purple" :: Nil
val colours = primaryColours ++ secondaryColours
val moreColours = "white" +: colours :+ "black"
"It is more efficient to add to the front of a List because it is a linked list"

"Iterating through a list"
colours.foreach(colour => println(colour))
for(c <- colours) yield c.length
colours.map(colour => colour.length)
colours.map(_.length)

val evenSequence = (1 to 10).withFilter(n => n % 2 == 0).map(n => n)
evenSequence.map(n => n / 2).sum
evenSequence.head
evenSequence.tail
evenSequence(3)

"An infinite list"
val elevenFromAnInfiniteStream = (1 to ##).collectFirst({case n => n > 10 }).get

"Collecting a list"
colours
val maxLength = colours.map(_.length).max
val reducedMaxLength = colours.map(_.length).reduce((a: Int, b: Int) => if (a >= b) a else b)
val joinedColours = colours.mkString(",")
val foldedColours = colours.foldLeft("")((agg, element) => agg + " " + element)
val collectedFourLetterColours = colours.collect({case colour if colour.length == 4 => colour})
val filteredAndReduced4LetterColours = colours.filter(_.length == 4).reduce(_ + " " + _)
val filteredAndReduced8LetterColours = colours.filter(_.length == 8).reduceLeftOption(_ + " " + _).getOrElse("There aren't any 8 letter colours in the list")
val numbersExtractedDoubledAndSummed = List("one", 1, "two", 2).collect({case element:Int => element * 2}).sum

"----------"
"-- Sets --"
"----------"
val unique = Set(10, 20, 30, 20, 20, 10)
unique.sum

"----------"
"-- Maps --"
"----------"

"Map is immutable by default"

"Building a map"
var immutableEmptyMap = Map[String, String]()
val colourMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
val cyanRGB = colourMap("green") | colourMap("blue")
colourMap.contains("cyan")
colourMap + ("white" -> 0xFFFFFF)

"A mutable map"
var mutableEmptyMap = scala.collection.mutable.Map[String, String]()
mutableEmptyMap += ("key" -> "value")
mutableEmptyMap
SortedMap("B" -> "Bravo", "A" -> "Alpha", "C" -> "Charlie")

val scoresToLetters = Map(1 -> Seq("A", "E"), 2 -> Seq("D", "G"))
val oneValues = scoresToLetters(1)
scoresToLetters.foreach(element => println(s"Element: key=${element._1} value=${element._2}"))
for(element <- scoresToLetters) yield s"Element: key=${element._1} value=${element._2}"
for(element <- scoresToLetters) yield element
val keySet = scoresToLetters.keySet
val keyIterable = scoresToLetters.keys
val values = scoresToLetters.values
val mapList = scoresToLetters.toList

"Collecting a map"
def fizzBuzzBang(n: Int): String = {
  Map(3 -> "Fizz", 5 -> "Buzz", 7 -> "Bang")
    .filter(n % _._1 == 0)
    .values
    .reduceLeftOption(_ + _)
    .getOrElse(n.toString)
}
(1 to 40).map(fizzBuzzBang).mkString(" ")

"--------------------------------"
" Lazy evaluation of collections "
"--------------------------------"
// https://alvinalexander.com/scala/how-to-create-lazy-views-collections-scala-cookbook
val eager = 1 to 10
val nowItsLazy = eager.view
val thisIsStillLazy = nowItsLazy.map(_ * 2)
val nowItsEagerAgain = thisIsStillLazy.force

thisIsStillLazy.map(_ * 2).force
