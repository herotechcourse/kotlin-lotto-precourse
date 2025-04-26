package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.util.Random

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun getNumbers():List<Int>{
        return numbers.sorted()
    }

    fun CreateLottoList(count: Int):List<Lotto>{
        //val randomLotto: List<Int> = listOf()
        val randomLotto=mutableListOf<Lotto>()
        for(i in 1..count){
            val RandomlottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
             randomLotto.add(Lotto(RandomlottoNumbers))
        }
        return randomLotto
    }
    fun CorrectNumbers(){

    }
    fun BonusNumbers(){

    }

    fun Calculator(){

    }


}
