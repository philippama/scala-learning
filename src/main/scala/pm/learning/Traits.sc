/*
Traits are a bit like abstract classes in that they can contain functionality
but a class can have more that one Trait. They cannot take class parameters.
 */

trait SafeStringUtils {
    def trimToNone(string: String): Option[String] = {
        Option(string) map(_.trim) filterNot(_.isEmpty)
    }
}

trait HtmlUtils {
    def removeMarkup(input: String) = {
        input
                .replaceAll("""</?\w[^>]*>""","")
                .replaceAll("<.*>","")
    }
}

class Page(val string: String) extends SafeStringUtils with HtmlUtils {
    def asPlainText: String = {
        trimToNone(string) map removeMarkup getOrElse "n/a"
    }
}

new Page("<html><body><h1>Introduction</h1></body></html>").asPlainText
new Page("  ").asPlainText

"To do enum-like things"
"----------------------"
object WeekDay {
    sealed trait EnumVal
    case object Mon extends EnumVal
    case object Tue extends EnumVal
    case object Wed extends EnumVal
    case object Thu extends EnumVal
    case object Fri extends EnumVal
    val daysOfWeek = Seq(Mon, Tue, Wed, Thu, Fri)
}
val today = WeekDay.Mon

object Config {
    sealed abstract class Environment(val message: String) {
        def tellHerAboutIt(name: String): Unit = {
            println(s"$name, ${this.message}")
        }
    }

    case object LOCAL extends Environment("This is a local config for local people.")
    case object DEV   extends Environment("Our developers are on it.")
    case object QA    extends Environment("One, two ... testing, testing...")
}
Config.DEV.message
Config.LOCAL.tellHerAboutIt("Julie")

