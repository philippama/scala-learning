import scala.collection.SortedMap
// See Learning Scala ch 6

"-" * 11
"-- Lists --"
"-" * 11

"List is an immutable linked list."

val range = 1 until 5
val inclusiveRange = 1 to 5
val evenSequence = (1 to 10).withFilter(n => n % 2 == 0).map(n => n)
evenSequence.map(n => n / 2).sum
evenSequence.head
evenSequence.tail
evenSequence(3)

val primaryColours = List("red", "green", "blue")
val secondaryColours = "yellow" :: "cyan" :: "purple" :: Nil
val colours = primaryColours ++ secondaryColours
colours.foreach(colour => println(colour))
for(c <- colours) yield c.length
colours.map(colour => colour.length)
colours.map(_.length)
val maxLength = colours.map(_.length)
                     .reduce((a: Int, b: Int) => if (a >= b) a else b)
val moreColours = ("white" :: colours) :+ "black"
"It is more efficient to add to the front of a List because it is a linked list"

"----------"
"-- Sets --"
"----------"
val unique = Set(10, 20, 30, 20, 20, 10)
unique.sum

"----------"
"-- Maps --"
"----------"

"Map is immutable by default"

var immutableEmptyMap = Map[String, String]()
val colourMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
val cyanRGB = colourMap("green") | colourMap("blue")
colourMap.contains("cyan")
colourMap + ("white" -> 0xFFFFFF)

var mutableEmptyMap = scala.collection.mutable.Map[String, String]()
mutableEmptyMap + ("key" -> "value")
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

