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
- [] Re-prompt input whenever an `IllegalArgumentException` occurs, resuming the process from the corresponding step.

## ▪︎ Output

- [x] Show the number of tickets issued and their numbers
    - [x] Sort numbers in ascending order
- [] Show the lotto result statistics
- [] show the profit rate rounded to the nearest tenth

## ▪︎ Domain

- [x] Calculate the quantity of purchased lottery tickets
- [x] Issue lottery tickets based on the purchased amount
- [x] Calculate result statistics
    - [] Compare how many numbers match
- [] Calculate profit rate
    - [] Formula: Total Prize Money / Lottery Purchase Amount
    - [] Round to the nearest tenth

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

- [] Throw an `IllegalArgumentException` if winning numbers and the bonus number are duplicated

## ▪︎ Conventions

- [] Error messages must start with `[ERROR]`
- [] Keep functions under 10 lines
- [] Avoid using else.
- [] Use Enum classes where applicable.
- [] Separate business logic from UI logic.
- [] Must implement program using the provided `Lotto` class.
    - [] Must not add any fields (instance variables) to the Lotto class other than numbers.
    - [] The visibility modifier private on numbers must not be changed.
    - [] Must not change the package of the Lotto class.
- [] To generate random values, use `Randoms.pickUniqueNumbersInRange()` from `camp.nextstep.edu.missionutils.Randoms.`
- [] To receive user input, use `Console.readLine()` from `camp.nextstep.edu.missionutils.Console.`
