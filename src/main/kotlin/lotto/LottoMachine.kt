package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateTickets(count:Int): List<Lotto>{
        return List(count){
             val numbers = Randoms.pickUniqueNumbersInRange(1,45,6)
             Lotto(numbers)

        }
    }
}