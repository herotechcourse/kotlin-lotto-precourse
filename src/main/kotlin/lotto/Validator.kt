package lotto

class Validator {
    fun isPurchaseAmountValid(purchaseAmount: String): Int {
        val number = cleanStringfromSpace(purchaseAmount).toIntOrNull() ?:
        throw IllegalArgumentException("The purchase amount must be a number.")
        if (number < 0 ) {
            throw IllegalArgumentException("The purchase amount must be a positive number.")
        }
        if (number % 1000 != 0) {
            throw IllegalArgumentException("The purchase amount must be divisible by 1000.")
        }
        return number
    }
    fun isWinningNumbersValid(input: String): List<Int> {
        validateInputIsNotNull(input)
        val inputCleaned = cleanAndSplit(input)
        validateAmount(inputCleaned)
        val validWinningNumbers = convertToInt(inputCleaned)
        validateRange(validWinningNumbers)
        validateUniqueness(validWinningNumbers)
        return validWinningNumbers
    }
    private fun validateInputIsNotNull(input: String)
    {
        if (input.isEmpty())
        {
            throw IllegalArgumentException("The input must not be empty.")
        }
    }
    private fun cleanAndSplit (input: String): List<String>
    {
        val inputCleaned = input.replace(" ","")
        val inputSplit = inputCleaned.split(",")
        return inputSplit
    }
    private fun validateAmount(numbers: List<String>)
    {
        if (numbers.size != 6) {
            throw IllegalArgumentException("The input must be 6 numbers, comma separated.")
        }
    }
    private fun convertToInt(input: List<String>): List<Int>
    {
        val numbers = mutableListOf<Int>()
        for (item in input) {
            val number = item.toIntOrNull() ?: throw IllegalArgumentException("Input must be an integer number.")
            numbers.add(number)
        }
        return numbers
    }
    private  fun validateRange(numbers: List<Int>) {
        for (number in numbers) {
            if (number < 1 || number > 45) {
                throw IllegalArgumentException("The number must be between 1 and 45.")
            }
        }
    }
    private fun validateUniqueness(numbers: List<Int>)
    {
        val uniqueNumbers = numbers.toSet()
        if (uniqueNumbers.size != numbers.size)
        {
            throw IllegalArgumentException("Each of winning numbers must be unique")
        }
    }
    fun isBonusNumberValid(inputNumber: String, winningNumbers: List<Int>): Int {
        val bonusNumber = cleanStringfromSpace(inputNumber).toIntOrNull() ?:
        throw IllegalArgumentException("The bonus number must be a single integer number.")
        validateNumberRange(bonusNumber)
        validateBonusNumberIsDifferentFromWinning(bonusNumber, winningNumbers)
        return bonusNumber
    }
    private fun validateNumberRange(number: Int) {
        if (number < 1 || number > 45) {
            throw IllegalArgumentException("The number must be between 1 and 45.")
        }
    }
    private fun validateBonusNumberIsDifferentFromWinning(bonusNumber: Int, winningNumbers: List<Int>) {
        for (number in winningNumbers) {
            if (bonusNumber == number)
            {
                throw IllegalArgumentException("The bonus number must be different from winning numbers.")
            }
        }
    }
    private fun cleanStringfromSpace(input: String): String{
        val inputCleaned = input.replace(" ","")
        return inputCleaned
    }
}