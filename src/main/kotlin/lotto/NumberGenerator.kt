package lotto

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    companion object{
        fun generate():List<Int>{
            return Randoms.pickUniqueNumbersInRange(1,45,6)
        }
    }
}