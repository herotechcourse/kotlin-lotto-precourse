package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

        fun main() {
            try {
                val purchaseAmt= readPurchaseAmt()
                val tickets= produceTickets(purchaseAmt)

                displayTickets(tickets)

                val winningNum= readWinningNum()
                val bonusNum= readBonusNum()

                val result= winning(tickets, winningNum, bonusNum)

                getResult(result)
                getProfit(result, purchaseAmt)

            } catch (e: IllegalArgumentException) {
                println(e.message)
                main() // Restart program on error
            }
        }

        private fun readPurchaseAmt(): Int {
            println("Please enter the purchase amount.")
            val input= Console.readLine()
            val amt= input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
            if (amt < 1000 || amt % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
            }
            return amt
        }

        private fun produceTickets(purchaseAmount: Int): List<Lotto> {
            val tktCount = purchaseAmount / 1000
            println("You have purchased $tktCount tickets.")

            val tickets= mutableListOf<Lotto>()
            repeat(tktCount) {
                val nums= Randoms.pickUniqueNumbersInRange(1, 45, 6)
                tickets.add(Lotto(nums))
            }
            return tickets
        }

        private fun displayTickets(tickets: List<Lotto>) {
            for (ticket in tickets) {
                println(ticket.getSortedNumbers())
            }
        }

        private fun readWinningNum(): List<Int> {
            println("Please enter last week's winning numbers.")
            val input= Console.readLine()
            val numbers= input.split(",").map { it.trim().toIntOrNull() }

            if (numbers.size != 6|| numbers.any { it== null|| it !in 1..45 }) {
                throw IllegalArgumentException("[ERROR] Please enter 6 numbers between 1 and 45, separated by commas.")
            }

            if (numbers.distinct().size!= 6) {
                throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
            }

            return numbers.map { it!! }
        }

        private fun readBonusNum(): Int {
            println("Please enter the bonus number.")
            val input= Console.readLine()
            val bonus= input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus must be a number.")

            if (bonus !in 1..45) {
                throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
            }
            return bonus
        }

        private fun winning(tickets:List<Lotto>, winningNums: List<Int>, bonusNumber:Int): Map<String, Int> {
            val result= mutableMapOf(
                "6" to 0,
                "5+bonus" to 0,
                "5" to 0,
                "4" to 0,
                "3" to 0
            )

            for (ticket in tickets) {
                val tktNums= ticket.getSortedNumbers()
                val matched= tktNums.count { it in winningNums }

                if (matched== 6) {
                    result["6"]= result["6"]!! + 1
                } else if (matched== 5 && bonusNumber in tktNums) {
                    result["5+bonus"] = result["5+bonus"]!! + 1
                } else if (matched== 5) {
                    result["5"]= result["5"]!! + 1
                } else if (matched== 4) {
                    result["4"]= result["4"]!! + 1
                } else if (matched== 3) {
                    result["3"]= result["3"]!! + 1
                }
            }

            return result
        }

        private fun getResult(result:Map<String, Int>) {
            println("Winning Statistics")
            println("---")
            println("3 Matches (5,000 KRW) – ${result["3"]} tickets")
            println("4 Matches (50,000 KRW) – ${result["4"]} tickets")
            println("5 Matches (1,500,000 KRW) – ${result["5"]} tickets")
            println("5 Matches + Bonus Ball (30,000,000 KRW) – ${result["5+bonus"]} tickets")
            println("6 Matches (2,000,000,000 KRW) – ${result["6"]} tickets")

        }

        private fun getProfit(result: Map<String, Int>, purchaseAmt: Int) {
            val winnings =
                result["3"]!! * 5000 +
                        result["4"]!!* 50000 +
                        result["5"]!!* 1_500_000 +
                        result["5+bonus"]!!* 30_000_000 +
                        result["6"]!!* 2_000_000_000

            val profitRate= (winnings.toDouble() / purchaseAmt) * 100
            println("Total return rate is ${"%.1f".format(profitRate)}%.")
        }


