
// Loops
println("Loops")
for (i <- 1 to 5) {print(i + ", ")}
for (i <- 1 until 5) {print(i + ", ")}

println("yield returning Seq")
val days = for (day <- 1 to 7) yield{s"Day $day:"}
for (day <- days) print(day + ", ")

println("An iterator guard")
val threes = for (i <- 1 to 20 if i % 3 == 0) yield i
val theSameThingAnotherWay = (1 to 20).withFilter(i => i % 3 == 0).map(i => i)
val fizzbuzz = for (i <- 1 to 20 if i % 3 == 0 if i % 5 == 0) yield i

println("Nested iterators")
for {first <- 1 to 2
     second <- 3 to 4}
  print(s"($first,$second)")

for (colour <- List("red", "green", "blue")) { println(colour) }

// Also while and do/while loops not used often

import java.time.LocalDate
import java.time.Period
val startDate = LocalDate.of(2019, 1, 1)
val endDate = LocalDate.of(2019, 1, 5)
val period = Period.between(startDate, endDate)
val numDays = period.getDays
val dates = for (i <- 0 to numDays) yield startDate.plusDays(i)
println(dates.map(_.toString).mkString(","))
