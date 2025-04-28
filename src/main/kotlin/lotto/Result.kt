package lotto

data class Result(
    val rankCounts: Map<Rank, Int>,
    val purchaseAmount: Int,
)
