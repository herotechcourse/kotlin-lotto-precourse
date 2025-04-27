package lotto

import camp.nextstep.edu.missionutils.Randoms

interface RandomNumbersGeneratorWrapper {
    fun generateRandomNumbersInRange(min: Int, max: Int, count: Int): List<Int>
}

class RandomNumbersGeneratorWrapperImpl : RandomNumbersGeneratorWrapper{
    override fun generateRandomNumbersInRange(min: Int, max: Int, count: Int): List<Int> {
        val listOfNumbers = Randoms.pickUniqueNumbersInRange(min,max,count)
        return listOfNumbers
    }

}