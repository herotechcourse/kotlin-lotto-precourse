package lotto


fun main() {
    // TODO: Implement the program
    val inputView: User = User(0,"",0)
    var user = inputView.getData()
    user?.let{
    user.displayInfo()
    }?: println("Invalid user")
    
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

