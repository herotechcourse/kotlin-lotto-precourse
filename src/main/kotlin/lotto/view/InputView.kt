package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Enter the purchase amount:")
        val input = Console.readLine()
        
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
    }
    
    fun readWinningNumbers(): List<Int> {
        println("Enter the winning numbers (comma-separated):")
        val input = Console.readLine()
        
        return try {
            input.split(",")
                .map { number -> number.trim() }
                .map { number -> number.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter valid numbers separated by commas.")
        }
    }
    
    fun readBonusNumber(): Int {
        println("Enter the bonus number:")
        val input = Console.readLine()
        
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid bonus number.")
        }
    }
} 