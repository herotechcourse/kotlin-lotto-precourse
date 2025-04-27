package lotto

interface BonusValidator : Validator {

    fun validateNumber(number: Int)

    fun validateDuplicatedNumber(number: Int, numbers: List<Int>) {
        require(number !in numbers) {
            "Bonus number must not duplicate with winning numbers."
        }
    }
}
