# kotlin-lotto-precourse

This is a command-line based Lotto game simulation written in Kotlin.  
The project allows users to purchase lotto tickets, enter winning numbers, and check their winning results and profit rate.

---

## 🎯 Features Implemented

- **Purchase Tickets**

  - User inputs the amount to purchase lotto tickets (1 ticket = 1000 units).
  - Random tickets are generated with 6 unique numbers (from 1 to 45).

- **Display Purchased Tickets**

  - Automatically displays how many tickets were bought and their numbers.

- **Winning Number Input**

  - User is prompted to enter 6 winning numbers and 1 bonus number.

- **Result Calculation**

  - Compares each ticket with the winning numbers.
  - Determines the rank based on the number of matching numbers and bonus.

- **Profit Rate Calculation**
  - Total reward is calculated based on ranks achieved.
  - Profit rate is displayed as a percentage.

---

## 📁 File Structure

src/ └── main/ └── kotlin/ └── lotto/ ├── Application.kt # Entry point of the app (main function) ├── InputView.kt # Handles all user input ├── OutputView.kt # Handles all console output ├── Lotto.kt # Represents a single Lotto ticket ├── LottoMachine.kt # Generates multiple Lotto tickets ├── LottoResult.kt # Calculates result statistics ├── Rank.kt # Enum class representing winning ranks ├── WinningNumbers.kt # Stores and compares winning numbers

## 🛠️ How to Run

1. Navigate to the source directory:

   cd src/main/kotlin/lotto

2. Compile the Kotlin files into a runnable JAR:

kotlinc \*.kt -include-runtime -d lotto.jar 3. Run the program:

java -jar lotto.jar

## Sample Flow

Enter purchase amount:
3000

You bought 3 tickets:
[5, 12, 18, 23, 30, 41]
[4, 11, 19, 29, 37, 43]
[2, 8, 16, 22, 39, 45]

Enter winning numbers (comma-separated):
4, 11, 19, 29, 37, 43

Enter bonus number:
45

Results:
6 numbers matched (Jackpot) - 0 matches
5 + Bonus matched - 0 matches
5 numbers matched - 1 matches
4 numbers matched - 0 matches
3 numbers matched - 1 matches

Total profit rate: 116.67
