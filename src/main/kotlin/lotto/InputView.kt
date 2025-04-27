object InputView {
    fun readAmount(): Int {
        println("Enter purchase amount (KRW):")
        return readLine().orEmpty().toIntOrNull() ?: throw IllegalArgumentException()
    }

    fun readWinningNumbers(): Set<Int> {
        println("Enter 6 winning numbers (space-separated):")
        return readLine().orEmpty()
            .split(" ")
            .map { it.toInt() }
            .toSet()
    }

    fun readBonusNumber(): Int {
        println("Enter bonus number:")
        return readLine().orEmpty().toInt()
    }
}