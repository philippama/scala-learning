"Simple class definitions"
"------------------------"
class A {
    def hi = "Hi from A"
    def hello = "Hello from A"
}
class B extends A {
    override def hello = "hello from B"
}
class C(val name: String, val message: String = "You're great!") extends A {
    def greet = s"Hello, $name. $message"
    def greet(overloaded: String): String = greet + " " + overloaded
}
"From A: " + new A().hi
"From B: " + new B().hi
"From C: " + new C("Philippa").hi
"From A: " + new A().hello
"From B: " + new B().hello
"From C: " + new C("Philippa").hello
"From C: " + new C("Philippa").greet
"From C: " + new C("Donald", "What are you playing at?").greet
"From C: " + new C(message = "Well done.", name = "Paul").greet
"From C: " + new C("Philippa").greet("Yes, really.")

"Class definition with parameters"
"--------------------------------"
class Car(val make: String, var reserved: Boolean, val seats: Int) {
    def reserve(r: Boolean): Unit = { reserved = r }
}
val t = new Car("Toyota", false, 5)
t.reserve(true)
println(s"My ${t.make} is now reserved? ${t.reserved}")

class Lotus(val color: String, reserved: Boolean, seats: Int) extends Car("Lotus", reserved, seats)
val l = new Lotus("Silver", false, 2)
println(s"Requested a ${l.color} ${l.make} with ${l.seats} seats")


"Class definition with type parameters"
"-------------------------------------"
// Class with type parameter A
class Singular[A](element: A) extends Traversable[A] {
    def foreach[B](f: A => B): Unit = f(element)
}

val singular: Singular[String] = new Singular("Planes")
singular.foreach(println) // The same as the statement below
singular foreach println  // The same as the statement above

"Abstract classes"
"----------------"

abstract class AbstractCar {
    val year: Int
    def automatic: Boolean // Abstract method
    def colour: String     // Abstract method

    override def toString = s"Car(year=$year, automatic=$automatic, colour=$colour)"
}

abstract class ManualCar extends AbstractCar {
    // Implement the abstract automatic method; leave everything else
    def automatic = false
}

class Mini(val year: Int, val colour: String) extends ManualCar // Note the method being implemented by a value

new Mini(2011, "Red").toString

// Can have anonymous classes

"apply() - the default method"
"----------------------------"

class Square() {
    def apply(n: Int): Int = n * n
}
val square = new Square()
square(5)

"Lazy values"
"-----------"
// Values will only be assigned when accessed if the 'lazy' keyword is used.
// Good e.g. for connections so we only get them when we need them?
lazy val snooze = {println("creating me now"); util.Random.nextInt}
print("Not created yet...")
snooze


"Access modifiers, final and sealed"
"----------------------------------"

class Access {
    val iAmPublic = 1
    protected val iCanBeAccessedByASubClass = 2
    private val iCannotBeAccessedByAnyOtherClass = 3
    private[this] val iCanOnlyBeAccessedByThisInstance = 4
//    private[pm] val iCanOnlyBeAccessedByPackagePm = 5 // Needs to be in a package pm
}

final class ICannotBeSubClassed {val xyz = 10}
sealed class ICanOnlyBeSubclassedByAClassInTheSameFile {val xyz = 10}

