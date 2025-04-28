package lotto.config

interface NumberGenerator {
    fun generate(): List<Int>
}