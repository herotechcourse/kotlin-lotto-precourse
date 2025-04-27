package lotto

object MockFactory {

    fun createMockLotto(): MockLotto {
        return MockLotto(listOf(1, 2, 3, 4, 5, 6))
    }

    fun createMockWinningLotto(): MockWinningLotto {
        return MockWinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
    }

}