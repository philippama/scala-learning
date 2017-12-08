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
