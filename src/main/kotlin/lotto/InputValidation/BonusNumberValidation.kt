package lotto.InputValidation

class BonusNumberValidation {
    //Check if bonus number is in range of 1 to 45
    fun ValidateBonusNumberInRange1to45(bonus_number: Int) {
        if ((bonus_number < 1) or (bonus_number > 45)) throw IllegalArgumentException("Bonus number needs to be in range of 1 to 45")
    }

    //Check if bonus number is different from winning numbers
    fun ValidateBonusNumberUniqueness(bonus_number: Int, winning_numbers: List<Int>) {
        if (bonus_number in winning_numbers) throw IllegalArgumentException("Bonus number must be different from winning numbers")
    }
}