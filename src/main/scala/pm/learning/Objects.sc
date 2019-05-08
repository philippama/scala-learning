"Objects are good for defining pure functions"
"and functions that work with I/O (similar to "
"Java static methods)."

object Hello {
    println("I am being instantiated.")
    def sayIt = "hello"
}
Hello.sayIt
Hello.sayIt

"Companion object"
"----------------"

object Companion {
    private val things = "private things"
    def apply(name: String): Companion = {
        new Companion(name)
    }
}
class Companion(param: String) {
    private val companionsThings = Companion.things
    def hello = s"Hello $param"
    def peek: String = s"I can see your ${Companion.things}"
    val hi = "Hi!"
}
Companion("my friend").hello
Companion("my friend").peek
Companion("gfhgfhf").hi

