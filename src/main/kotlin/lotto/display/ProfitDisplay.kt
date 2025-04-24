package lotto.display

import java.util.Locale

class ProfitDisplay {

    // Function to format the return rate with one decimal point
    private fun formatReturnRate(returnRate: Double): String {
        return String.format(Locale.US, "%.1f", returnRate)
    }

    // Function to print the formatted return rate
    private fun printReturnRate(formattedRate: String) {
        println("Total return rate is $formattedRate%.")
    }

    // Main function to display the return rate
    fun displayReturnRate(returnRate: Double) {
        val formattedRate = formatReturnRate(returnRate)
        printReturnRate(formattedRate)
    }
}
