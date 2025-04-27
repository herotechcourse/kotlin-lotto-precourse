package camp.nextstep.edu.missionutils

object Randoms {
    fun pickUniqueNumbersInRange(startInclusive: Int, endInclusive: Int, count: Int): List<Int> {
        require(startInclusive <= endInclusive) { "[ERROR] Start must be <= end." }
        require(count <= (endInclusive - startInclusive + 1)) { "[ERROR] Count is too large." }
        return (startInclusive..endInclusive).shuffled().take(count)
    }
}
