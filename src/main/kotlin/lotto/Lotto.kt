package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.util.Random
import kotlin.collections.plusAssign
import kotlin.text.get

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun getNumbers():List<Int>{
        return numbers.sorted()
    }

companion object {
    fun CreateLottoList(count: Int): List<Lotto> {
        //val randomLotto: List<Int> = listOf()
        val randomLotto = mutableListOf<Lotto>()
        for (i in 1..count) {
            val RandomlottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val RandomlottoNumberssort = RandomlottoNumbers.sorted()
            randomLotto.add(Lotto(RandomlottoNumberssort))
        }
        return randomLotto
    }
}

    fun CorrectNumbers(lottolist: List<Int>,lottocorrectlist:List<Int>,bonusnumber: Int): Int {
        var count=0
    for(i in lottolist.indices){//수정해야함.
      for(j in lottocorrectlist.indices){
       count=OutputCount(count,lottolist[i],lottocorrectlist[j])
      }
        if(lottolist[i] == bonusnumber) {
            count += 1
        }
   }
        return count
    }

    fun OutputCount(counting:Int,lottolistin:Int ,lottocorrectlistin:Int):Int{
        var counted=counting
        if(lottolistin== lottocorrectlistin){
            counted+=1
        }
        return counted
    }



    fun Calculator(){

    }


}
