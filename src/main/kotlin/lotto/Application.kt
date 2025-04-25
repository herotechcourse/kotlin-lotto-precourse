package lotto
import camp.nextstep.edu.missionutils.Console
//import camp.nextstep.edu.missionutils.Randoms


fun main() {
    print("Please enter the purchase amount. ")
    println()
    val amount = Console.readLine().toIntOrNull()

    if (amount == null || amount % 1000 != 0)
        throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1000.")

    print("amount is $amount")
}
