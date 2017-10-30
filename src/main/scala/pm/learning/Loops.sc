
// Loops
println("Loops")
for (i <- 1 to 5) {print(i + ", ")}
for (i <- 1 until 5) {print(i + ", ")}

println("yield returning collection")
val days = for (day <- 1 to 7) yield{s"Day $day:"}
for (day <- days) print(day + ", ")

println("An iterator guard")
val threes = for (i <- 1 to 20 if i % 3 == 0) yield i
val fizzbuzz = for (i <- 1 to 20 if i % 3 == 0 if i % 5 == 0) yield i

println("Nested iterators")
for {first <- 1 to 2
     second <- 3 to 4}
  print(s"($first,$second)")

// Also while and do/while loops not used often
