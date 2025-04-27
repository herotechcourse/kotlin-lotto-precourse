package lotto

class StubNumbersStrategy : GenerateStrategy {
    private val numbers = listOf(0, 1, 2, 3, 4, 5)
    override fun generate(): List<Int> {
        return numbers.map { it + 1 }
    }
}
