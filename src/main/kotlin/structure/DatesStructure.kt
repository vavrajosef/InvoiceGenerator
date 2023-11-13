package structure

import java.time.LocalDate

class DatesStructure(val dateOfIssue: LocalDate = LocalDate.now()!!,
                     val datePerformanceOfSupply: LocalDate = getDatePerformanceOfSupply(dateOfIssue),
                     val dueDate: LocalDate = getDueDate(dateOfIssue)
) {
    companion object {
        fun getDatePerformanceOfSupply(date: LocalDate): LocalDate {
            val resultDate = date.minusMonths(1)
            return resultDate.withDayOfMonth(resultDate.month.length(resultDate.isLeapYear))
        }

        fun getDueDate(date: LocalDate): LocalDate {
            return date.plusMonths(1)
        }
    }
}