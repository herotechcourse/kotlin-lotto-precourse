# 💰kotlin-lotto-precourse💰

# 📝 List of Features

## ▪︎ Input

- [x] Read the number of lottery tickets
    - [x] Throw an `IllegalArgumentException` if the value is null or blank
    - [x] Throw an `IllegalArgumentException` if the value is not a number
- [x] Read the winning numbers
    - [x] Throw an `IllegalArgumentException` if the value is null or blank
    - [x] Throw an `IllegalArgumentException` if the value is not a number
    - [x] Throw an `IllegalArgumentException` if the value cannot separate by comma
- [x] Read the bonus number
    - [x] Throw an `IllegalArgumentException` if the value is null or blank
    - [x] Throw an `IllegalArgumentException` if the value is not a number
- [x] Re-prompt input whenever an `IllegalArgumentException` occurs, resuming the process from the corresponding step.

## ▪︎ Output

- [x] Show the number of tickets issued and their numbers
    - [x] Sort numbers in ascending order
- [x] Show the lotto result statistics
- [x] show the profit rate rounded to the nearest tenth

## ▪︎ Domain

- [x] Calculate the quantity of purchased lottery tickets
- [x] Issue lottery tickets based on the purchased amount
- [x] Calculate result statistics
    - [x] Compare how many numbers match
- [x] Calculate profit rate
    - [x] Formula: Total Prize Money / Lottery Purchase Amount

## ▪︎ Exception

### ▪︎ Purchase Amount

- [x] Throw an `IllegalArgumentException` if the amount of lottery tickets is not between `1,000` and `100,000`
- [x] Throw an `IllegalArgumentException` if the purchased amount is not divisible by `1,000

### ▪︎ Lotto Number

- [x] Throw an `IllegalArgumentException` if the number is not between 1 and 45

### ▪︎ Lotto

- [x] Throw an `IllegalArgumentException` if numbers are duplicated
- [x] Throw an `IllegalArgumentException` if numbers do not contain 6 numbers

### ▪︎ Winning Lotto & Bonus Number

- [x] Throw an `IllegalArgumentException` if winning numbers and the bonus number are duplicated

## ▪︎ Conventions

- [x] Error messages must start with `[ERROR]`
- [x] Keep functions under 10 lines
- [x] Avoid using else.
- [x] Use Enum classes where applicable.
- [x] Separate business logic from UI logic.
- [x] Must implement program using the provided `Lotto` class.
    - [x] Must not add any fields (instance variables) to the Lotto class other than numbers.
    - [x] The visibility modifier private on numbers must not be changed.
    - [x] Must not change the package of the Lotto class.
- [x] To generate random values, use `Randoms.pickUniqueNumbersInRange()` from `camp.nextstep.edu.missionutils.Randoms.`
- [x] To receive user input, use `Console.readLine()` from `camp.nextstep.edu.missionutils.Console.`

# 🌊 Flow

* If any input is invalid, display an error message and prompt the user to input again.

1. Prompt the user to input the lottery purchase amount in multiples of `1,000` KRW.
2. Display the number of lottery tickets purchased and their respective numbers.
3. Prompt the user to input 6 winning numbers separated by commas `,`.
4. Prompt the user to input 1 bonus number.
5. Compare the purchased lottery tickets with the winning numbers to generate statistics.
6. Display the winning statistics and the total return rate (rounded to the nearest tenth).

# 💲 Example Execution

```text
Please enter the purchase amount.
3000

You have purchased 3 tickets.
[19, 23, 25, 31, 34, 38]
[9, 17, 19, 23, 25, 43]
[4, 5, 18, 22, 27, 41]

Please enter last week's winning numbers.
4,5,18,22,27,45

Please enter the bonus number.
41

Winning Statistics
---
3 Matches (5,000 KRW) – 0 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 1 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 1,000,000.0%.
```
