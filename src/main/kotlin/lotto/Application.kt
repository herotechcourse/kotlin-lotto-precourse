package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // prompt user for purchase amount
    println("Please enter the purchase amount.")
    val amountInput = Console.readLine().toInt()
    val tickets = parseAmount(amountInput)

    // parse tickets to generate numbers
    println("\nYou have purchased $tickets tickets.")
    val lottoNumbers = generateLotto(tickets)
    for (numbers in lottoNumbers) {
        println(numbers)
    }

    // prompt user for last week's winning numbers
    println("\nPlease enter last week's winning numbers.")
    val winningNumbers = mutableListOf<Int>()
    val winningInput = Console.readLine()
    val numbers = winningInput.split(",")
    for (number in numbers) {
        winningNumbers.add(number.toInt())
    }

    // prompt user for the bonus number
    println("\nPlease enter the bonus number.")
    val bonusNumber = Console.readLine().toInt()

    // initialise key value pair with 0
    val results = mutableMapOf<String, Int>()
    results["3"] = 0
    results["4"] = 0
    results["5"] = 0
    results["5_bonus"] = 0
    results["6"] = 0

    // update values using the functions in Lotto class
    for (lotto in lottoNumbers) {
        val matchCount = lotto.countMatch(winningNumbers)
        val hasBonus = lotto.containsBonus(bonusNumber)

        if (matchCount == 6) {
            results["6"] = results["6"]!! + 1
        } else if (matchCount == 5 && hasBonus) {
            results["5_bonus"] = results["5_bonus"]!! + 1
        } else if (matchCount == 5) {
            results["5"] = results["5"]!! + 1
        } else if (matchCount == 4) {
            results["4"] = results["4"]!! + 1
        } else if (matchCount == 3) {
            results["3"] = results["3"]!! + 1
        }
    }

    println("\nWinning Statistics")
    println("---")
    println("3 Matches (5,000 KRW) – ${results["3"]} tickets")
    println("4 Matches (50,000 KRW) – ${results["4"]} tickets")
    println("5 Matches (1,500,000 KRW) – ${results["5"]} tickets")
    println("5 Matches + Bonus Ball (30,000,000 KRW) – ${results["5_bonus"]} tickets")
    println("6 Matches (2,000,000,000 KRW) – ${results["6"]} tickets")

    // calculate total return rate
    val totalPrizeMoney =
        results["3"]!! * 5000 +
                results["4"]!! * 50000 +
                results["5"]!! * 1500000 +
                results["5_bonus"]!! * 30000000 +
                results["6"]!! * 2000000000

    val returnRate = (totalPrizeMoney.toDouble() / amountInput) * 100

    println("Total return rate is ${String.format("%.1f", returnRate)}%.")
}

fun parseAmount(input: Int): Int {
    // return input if amount if divisible by 1,000
    if (input % 1000 != 0) {
        throw IllegalArgumentException("The amount must be divisible by 1,000.")
    }
    return input/1000
}

fun generateLotto(tickets: Int): List<Lotto> {
    // generate 6 random numbers between 1 and 45 based on the number of tickets
    val result = mutableListOf<Lotto>()
    repeat(tickets) {
        result.add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
    }
    return result
}