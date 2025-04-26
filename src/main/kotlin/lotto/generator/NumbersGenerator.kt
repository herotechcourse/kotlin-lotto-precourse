package lotto.generator

import lotto.Lotto

interface NumbersGenerator {
    fun generate(): List<Int>
}