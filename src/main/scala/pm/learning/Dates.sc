import java.time.LocalDate
import java.time.format.DateTimeFormatter

"Creating a sequence of dates from a start date to an end date"
val startDate = LocalDate.of(2018,12,25)
val endDate = LocalDate.of(2018, 12, 31)
val numDays = (endDate.toEpochDay - startDate.toEpochDay).toInt

val dates = for (days <- 0 to numDays) yield startDate.plusDays(days)

val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")

val stringDates = dates.map(date => date.format(dateFormat))

val parsedDates = stringDates.map(LocalDate.parse(_, dateFormat))

