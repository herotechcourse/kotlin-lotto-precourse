package lotto

data class Result(
    val results: Map<Rank, Int>,
    val purchaseAmount: Int,
)
