package lotto

import camp.nextstep.edu.missionutils.Randoms
fun main() {
    // TODO: Implement the program
    val inputView: User = User(0,"",0)
    var user = inputView.getData()
    user?.let{
    user.displayInfo()
    }?: println("Invalid user")
    val generator = LotteryGenerator("")
    val current_lot: String = generator.generateLottoNumbers()
    println("Current Lottery: ${current_lot ?: "No lottery numbers generated"}")  // Example output: "5,12,23,29,37,42"
 
    val winningNumbers: String = user?.winningNumbers?: "0,0,0,0,0,0"
    val bonus: String = user?.bonus.toString()?: "0"
    val lott_current: String = current_lot?:"0,0,0,0,0,0"
    val result = checkData(user?.winningNumbers?: "0,0,0,0,0,0",user?.bonus.toString()?: "0",current_lot?:"0,0,0,0,0,0")
    println("Result: $result")
}  

fun checkData(winningNumbers: String, bonus: String, lotteryNumbers: String): String {
    val winningSet = winningNumbers.split(",")
        .mapNotNull { it.trim().toIntOrNull() }
        .toSet()

    val lotterySet = lotteryNumbers.split(",")
        .mapNotNull { it.trim().toIntOrNull() }
        .toSet()

    val bonusNumber = bonus.trim().toIntOrNull()

    if (winningSet.size != 6 || lotterySet.size != 6 || bonusNumber == null) {
        return "Invalid input! Please make sure you enter exactly 6 numbers and a valid bonus number."
    }

    val matchedNumbers = winningSet.intersect(lotterySet)
    val matchCount = matchedNumbers.size
    val bonusMatched = lotterySet.contains(bonusNumber)

    return when {
        matchCount == 6 -> "Congratulations! 🥇 First Prize!"
        matchCount == 5 && bonusMatched -> "Congratulations! 🥈 Second Prize!"
        matchCount == 5 -> "Congratulations! 🥉 Third Prize!"
        matchCount == 4 -> "You won 4th Prize!"
        matchCount == 3 -> "You won 5th Prize!"
        else -> "No Prize. Better luck next time!"
    }
}

data class LotteryGenerator(var lNumbers: String){
    fun generateLottoNumbers(): String {
        lNumbers =  Randoms.pickUniqueNumbersInRange(1, 45, 6)
        .sorted()
        .joinToString(",")
    return lNumbers
    
    }
    
}

data class User(
val purchaseAmount: Int,
val winningNumbers: String,
val bonus: Int

) {
fun displayInfo() {
    println("Budget: $purchaseAmount, Winning Numbers: $winningNumbers , Bonus: $bonus")
}
fun getData(): User?{
    println("Enter your Purchase Amount:")
        val pAmount = readLine()?.toIntOrNull() ?: 0
        println("Enter your Winning Number:")
        val wNumber = readLine().orEmpty()
        println("Enter your Bonus:")
        val bonus = readLine()?.toIntOrNull() ?: 0
        if (validateInputs(pAmount,wNumber,bonus)){
        return User(pAmount, wNumber, bonus)
        }else{
            return null
        }
}
fun validateInputs(
    purchaseAmount: Int,
    winningNumber: String,
    bonus: Int
): Boolean {
    // Validation 1: Check if first number is divisible by 1000
    val ispurchaseAmount = purchaseAmount % 1000 == 0
    
    // Validation 2: Check comma-separated string has exactly 6 numbers in range 1-45
    val numbers = winningNumber.split(",").map { it.trim() }
    val hasSixValidNumbers = numbers.size == 6 && numbers.all { numStr ->
        numStr.toIntOrNull()?.let { it in 1..45 } ?: false
    }
    
    // Validation 3: Check single number is in range 1-45
    val isbonusValid = bonus in 1..45

    if (!ispurchaseAmount) {
        println("Purchase amount should be divisible by 1000 ")
    }
    if (!hasSixValidNumbers) {
        println("Winning number does not  match the input citeria ")
    }
    if (!isbonusValid) {
        println("Bonus number should be between  1-45 ")
    }
    
    
    // Return true only if all validations pass
    return ispurchaseAmount && hasSixValidNumbers && isbonusValid
}
}

