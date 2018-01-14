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

"Other"
"-----"

classOf[String].getMethods.map(_.getName)
