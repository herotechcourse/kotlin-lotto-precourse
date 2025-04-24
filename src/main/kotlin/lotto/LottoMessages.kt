package lotto

object LottoMessages {
    val welcome = "Welcome to Lotto Machine! Please, insert the amount do you want to " +
            "invest on your Lotto Ticket. (It has to be divisible by 1000):"
    val tryAgainDivisible = " [ERROR] The amount has to be divisible by 1000! Please insert a correct amount value:"
    val winningNumbers = "Please, Enter 6 winning numbers (coma-separated):"
    val invalidWinningNumbers = "[ERROR] Invalid input. Please enter 6 winning numbers (coma-separated):"
    val invalidInput = "[ERROR] Invalid Input. Please try again:"
    val bonusNumber = "Digit a bonus number:"

    val blankInput = "[ERROR] Input cannot be blank."
    val smallThanOne = "[ERROR] Input cannot be smaller than 1."
    val divisibleByThousand = "[ERROR] Input has to be divisible by 1000."
    val rangeOneToFortyfive = "[ERROR] All numbers must be between 1 and 45."
    val duplicate = "[ERROR] Numbers cannot contain duplicate numbers."
    val sixNumbers = "[ERROR] Ticket must contain 6 numbers."
    val isANumber = "[ERROR] It contains a non numeric."
}