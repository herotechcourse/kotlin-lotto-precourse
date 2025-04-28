# Kotlin Lotto Precourse Mission

A console-based Lotto simulation game implemented in Kotlin as part of the Woowacourse pre-course mission. This project demonstrates core programming concepts including object-oriented design, input validation, and unit testing within the constraints of the mission requirements.

## ❛ Overview
This project is a Lotto ticket application developed using Kotlin. Users can purchase Lotto tickets by entering an amount of money, and the program issues tickets accordingly. Each ticket contains six unique random numbers ranging from 1 to 45. After purchasing, users input the winning numbers and a bonus number. The program then compares the purchased tickets with the winning numbers, determines the prize ranks based on the matches, and calculates the total profit rate.

## ❛ Features

* **Lotto Ticket Purchase:**
    - Accepts the purchase amount from the user.
    - Validates input to ensure it is a positive integer and a multiple of 1,000 KRW. 
    - Issues one Lotto ticket per 1,000 KRW.

* **Lotto Ticket Generation:**
    - Generates Lotto tickets, each with 6 unique numbers randomly selected from 1 to 45.
    - Sorts the numbers for each ticket in ascending order.
    - Displays the total number of purchased tickets.

* **Winning & Bonus Number Input:**
    - Prompts the user to enter the 6 winning Lotto numbers.
    - Ensures that the numbers are unique, within the range 1-45, and that exactly 6 numbers are entered.
    - Prompts the user to input a bonus number, ensuring it is within the range and not duplicated in the winning numbers.

* **Result Calculation & Statistics:**
    - Compares each purchased ticket to the winning numbers and bonus number.
    - Determines the prize rank for each ticket:
        - **1st Place:** 6 matching numbers (Prize: 2,000,000,000 KRW)
        - **2nd Place:** 5 matching numbers + bonus number (Prize: 30,000,000 KRW)
        - **3rd Place:** 5 matching numbers (Prize: 1,500,000 KRW)
        - **4th Place:** 4 matching numbers (Prize: 50,000 KRW)
        - **5th Place:** 3 matching numbers (Prize: 5,000 KRW)

* **Output Display:**
    - Displays the number of tickets won for each prize rank.
    - Calculates the total return on investment (ROI) based on the total prize money won and the initial purchase amount.
    - Displays the ROI as a percentage, rounded to one decimal place.

* **Error Handling:**
    - Implements robust error handling for invalid inputs. All error messages are prefixed with `[ERROR]`.
    - Ensures the program prompts the user to re-enter invalid inputs.

## ❛ Directory Structure

```
src/
├── main/
│   └── kotlin/
│       └── lotto/
│           ├── Application.kt
│           ├── Lotto.kt
│           ├── LottoMachine.kt
│           ├── LottoResult.kt
│           ├── LottoRank.kt
│           ├── WinningLotto.kt
│           ├── constant/
│           │   └── LottoConstants.kt
│           ├── validation/
│           │   └── LottoValidator.kt
│           └── view/
│               ├── InputView.kt
│               └── OutputView.kt
└── test/
    └── kotlin/
        └── lotto/
            ├── ApplicationTest.kt
            ├── domain/
            │   ├── LottoMachineTest.kt
            │   ├── LottoRankTest.kt
            │   ├── LottoResultTest.kt
            │   ├── LottoTest.kt
            │   └── WinningLottoTest.kt
            └── validation/
                └── LottoValidatorTest.kt
```

