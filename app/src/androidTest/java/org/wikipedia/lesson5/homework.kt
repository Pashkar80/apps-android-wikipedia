import Days.FRIDAY
import Days.MONDAY
import Days.SATURDAY
import Days.SUNDAY
import Days.THURSDAY
import Days.TUESDAY
import Days.WEDNESDAY
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Schedule {

    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    private var weekDay: Days? = null

    fun monday(func: () -> Unit) = addDay(MONDAY, func)
    fun tuesday(func: () -> Unit) = addDay(TUESDAY, func)
    fun wednesday(func: () -> Unit) = addDay(WEDNESDAY, func)
    fun thursday(func: () -> Unit) = addDay(THURSDAY, func)
    fun friday(func: () -> Unit) = addDay(FRIDAY, func)
    fun saturday(func: () -> Unit) = addDay(SATURDAY, func)
    fun sunday(func: () -> Unit) = addDay(SUNDAY, func)

    fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    operator fun invoke(func: Schedule.() -> Unit) {
        func()
    }

    operator fun String.rangeTo(endTime: String): Pair<String, String> {
        return this to endTime
    }

    infix fun Pair<String, String>.schedule(lesson: String) {
        addSchedule(
            weekDay!!,
            ScheduleEntity(
                lesson,
                LocalTime.parse(first, timeFormatter),
                LocalTime.parse(second, timeFormatter)
            )
        )
    }

    private fun addDay(day: Days, func: () -> Unit) {
        this.weekDay = day
        func()
        this.weekDay = null
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(
                                timeFormatter
                            )
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }
}

fun main() {
    val schedule = Schedule()
    schedule {
        monday {
            "10:30".."11:10" schedule "Biology"
            "11:15".."11:55" schedule "Chemistry"
            "09:00".."09:40" schedule "Mathematics"
            "09:45".."10:25" schedule "History"
        }

        tuesday {
            "09:00".."09:40" schedule "English"
            "09:45".."10:25" schedule "Geography"
            "11:15".."11:55" schedule "Art"
            "10:30".."11:10" schedule "Physics"
        }

        wednesday {
            "11:15".."11:55" schedule "Biology"
            "09:00".."09:40" schedule "Literature"
            "10:30".."11:10" schedule "History"
            "09:45".."10:25" schedule "Mathematics"
        }

        thursday {
            "11:15".."11:55" schedule "Physics"
            "10:30".."11:10" schedule "Geography"
            "09:00".."09:40" schedule "Chemistry"
            "09:45".."10:25" schedule "English"
        }

        friday {
            "09:45".."10:25" schedule "Literature"
            "11:15".."11:55" schedule "History"
            "09:00".."09:40" schedule "Art"
            "10:30".."11:10" schedule "Mathematics"
        }
        saturday{
            "09:00".."09:40" schedule "Art"
            "09:45".."10:25" schedule "Literature"
        }
        sunday {
            "09:45".."10:25" schedule "Geography"
            "11:15".."11:55" schedule "Art"
        }
    }
    println(schedule.toString())
}