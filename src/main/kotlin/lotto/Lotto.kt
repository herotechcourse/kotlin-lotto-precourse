package lotto

data class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6 && numbers.toSet().size == 6) {
            "Lotto numbers must be 6 unique numbers"
        }
    }
}
