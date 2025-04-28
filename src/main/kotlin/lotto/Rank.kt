package lotto

//로또 결과 등수를 나타내는 열거형(enum) 클래스. 
//등수별로 몇 개의 숫자를 맞춰야 하는지(matchCount),
//얼마의 상금을 받는지(prize),
//보너스 번호가 필요한지 여부(bonusRequired)를 정의
enum class Rank(val matchCount: Int, val prize: Int, val bonusRequired: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun valueOf(matchCount: Int, bonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }


    fun description(): String {
        val formattedPrize = "%,d".format(prize)
        return if (this == SECOND) {
            "5 Matches + Bonus Ball ($formattedPrize KRW)" // 공백과 기호를 수정
        } else {
            "$matchCount Matches ($formattedPrize KRW)" // 동일한 형식 적용
        }
    }


}