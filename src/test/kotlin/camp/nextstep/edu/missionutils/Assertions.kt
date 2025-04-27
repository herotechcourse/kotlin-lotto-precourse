package camp.nextstep.edu.missionutils

import org.assertj.core.api.Assertions.assertThat

object Assertions {
    fun assertSimpleTest(test: () -> Unit) {
        test()
    }

    fun assertRandomUniqueNumbersInRangeTest(test: () -> Unit, vararg expected: List<Int>) {
        test()
    }
}

