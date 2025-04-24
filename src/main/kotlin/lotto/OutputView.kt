package lotto

enum class OutputView {
    REQUEST_PURCHASE_AMOUNT {
        override fun printMessage(data: Any?) = println("Please enter the purchase amount.")
    },
    REQUEST_WINNING_NUMBERS {
        override fun printMessage(data: Any?) = println("Please enter last week's winning numbers.")
    },
    REQUEST_BONUS_NUMBER {
        override fun printMessage(data: Any?) = println("Please enter the bonus number.")
    },
    ERROR {
        override fun printMessage(data: Any?) {
            val errorMessage = data as? String ?: "Unknown"
            println("[ERROR] $errorMessage")
        }
    },
    PRINT_RESULT {
        override fun printMessage(data: Any?) = println("result will be printed here.")
    };

    abstract fun printMessage(data: Any?)
}
