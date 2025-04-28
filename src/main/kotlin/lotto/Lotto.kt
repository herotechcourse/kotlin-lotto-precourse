package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Config.LENGTH_OF_LOTTO) { "[ERROR] Lotto must contain exactly ${Config.LENGTH_OF_LOTTO} numbers." }
        require(numbers.distinct().size == Config.LENGTH_OF_LOTTO) { "[ERROR] Lotto numbers must be unique."}
        require(numbers.all {
            it in Config.MIN_LOTTO_NUMBER..Config.MAX_LOTTO_NUMBER
        }) { "[ERROR] Lotto numbers must be between ${Config.MIN_LOTTO_NUMBER} and ${Config.MAX_LOTTO_NUMBER}."}
    }

    fun getNumbers() = numbers.sorted()
}
