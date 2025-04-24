package lotto

object Messages {
    const val PURCHASE_AMOUNT = "Please enter the purchase amount."
    const val TICKETS_PURCHASED = "You have purchased %d tickets."
    const val ERROR = "[ERROR] %s"
    const val ERROR_INVALID_INPUT = "Invalid input"
    const val ERROR_INVALID_NUMBER = "Enter a valid number"
    const val ERROR_NEGATIVE_NUMBER = "Enter a positive number"
    const val ERROR_NOT_THOUSANDS = "Enter a number divisible by 1000"


    fun display(message: String, vararg args: Any) {
        println(message.format(*args))
    }

}