# kotlin-lotto-precourse
A Kotlin console app to buy lottery tickets, input winning numbers, and calculate winnings and return rate — structured with clean architecture.

## 📜 Features
Purchase tickets (1,000 KRW per ticket)

Generate 6 unique numbers per ticket (1–45)

Input last week's winning numbers and bonus ball

Automatically rank results and calculate total return rate

Friendly error messages for invalid inputs

## 🏛 Structure
main.kt — coordinates the app

Lotto.kt — ticket model

Rank.kt — prize enum

LottoEngine.kt — business logic

InputView.kt / OutputView.kt — handles UI

## ⚙️ Run
Kotlin 1.9.24

camp.nextstep.edu.missionutils.Randoms and Console used

Launch main() to start!

## 🧹 Code Highlights
Functions < 10 lines

No else — early return style

Enum used for ranks

Business logic separated from UI

Testable core modules

## Steps to follow to create the lotto project:
- Add more validation and functions to Lotto
- Add function to get purchase amount
- Add function to getWinnningNumbers
- Create function to read bonus number
- Add function to display purchased tickets
- Add rank funtion to show the five prize ranks
- Create function to display lotto results
- Add function to buy tickets
- Create function to evaluate and calculate ticket results
- Use InputView, LottoEngine, and OutputView for clean main flow
- Add tests for Lotto, Rank and LottoEngine