package lotto

class StubLottoNumberGenerator(private val fixedNumber: List<Int>) : LottoNumberGenerator {
    override fun generateNumbers(): List<Int> {
        return fixedNumber
    }
}