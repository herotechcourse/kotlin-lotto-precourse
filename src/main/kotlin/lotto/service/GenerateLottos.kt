package lotto.service

import lotto.Lotto

class GenerateLottos {
    fun generate(count: Int): List<Lotto> {
        return List(count) {
            val numbers = (1..45).shuffled()
                .take(6)
                .sorted()
            Lotto(numbers)
        }
    }
}