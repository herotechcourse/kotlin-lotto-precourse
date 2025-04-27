package lotto

class FixedRandomGenerator : RandomGenerator {

    override fun nextSortedUniqueNumbers() = listOf(8, 43, 45, 2, 10, 4).sorted()
}
