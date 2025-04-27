package lotto

enum class LottoRank(val prize: Int, val matchCount: Int) {
    FIRST(2_000_000_000, 6) {
        override fun match(lotto: Lotto, winningLotto: WinningLotto): Boolean {
            return lotto.match(winningLotto.winningNumbers) == matchCount
        }
    },
    SECOND(30_000_000, 5) {
        override fun match(lotto: Lotto, winningLotto: WinningLotto): Boolean {
            return lotto.match(winningLotto.winningNumbers) == matchCount && lotto.contains(winningLotto.bonusNumber)
        }
    },
    THIRD(1_500_000, 5) {
        override fun match(lotto: Lotto, winningLotto: WinningLotto): Boolean {
            return lotto.match(winningLotto.winningNumbers) == matchCount && !lotto.contains(winningLotto.bonusNumber)
        }
    },
    FOURTH(50_000, 4) {
        override fun match(lotto: Lotto, winningLotto: WinningLotto): Boolean {
            return lotto.match(winningLotto.winningNumbers) == matchCount
        }
    },
    FIFTH(5_000, 3) {
        override fun match(lotto: Lotto, winningLotto: WinningLotto): Boolean {
            return lotto.match(winningLotto.winningNumbers) == matchCount
        }
    },
    NONE(0, 2) {
        override fun match(lotto: Lotto, winningLotto: WinningLotto): Boolean {
            return lotto.match(winningLotto.winningNumbers) <= matchCount
        }
    };

    abstract fun match(lotto: Lotto, winningLotto: WinningLotto): Boolean

    fun isSecond(): Boolean {
        return this == SECOND
    }

    companion object {
        fun calculate(lotto: Lotto, winningLotto: WinningLotto): LottoRank {
            return LottoRank.entries.first {
                it.match(lotto, winningLotto)
            }
        }
    }
}
