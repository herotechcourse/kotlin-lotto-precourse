package lotto.fixture

import lotto.model.random.RandomNumbersGenerator

class FakeRandomNumbersGenerator(private vararg val numbers: Int): RandomNumbersGenerator {
    override fun generate(): List<Int> {
        return numbers.toList()
    }
}
