"Building Iterators"
"------------------"
Iterator.apply("a", "b", "c").toList

Iterator.iterate(1)(2 * _).takeWhile(_ < 100).toList

Iterator.fill(3)(Math.random()).toList


