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
- [] Read the bonus number
    - [] Throw an `` if the value is null or blank
    - [] Throw an `IllegalArgumentException` if the value is not a number
- [] Re-prompt input whenever an `IllegalArgumentException` occurs, resuming the process from the corresponding step.

## ▪︎ Output

- [] Show the number of tickets issued and their numbers
    - [] Sort numbers in ascending order
- [] Show the lotto result statistics
- [] show the profit rate rounded to the nearest tenth

## ▪︎ Domain

- [] Validate the amount of lottery tickets must be between `1,000` and `100,000`
    - Throw an `IllegalArgumentException` if the value is out of range
- [] Calculate the number of purchased lottery tickets
    - [] Throw an `IllegalArgumentException` if amount is not divisible by `1,000
- [] Issue lottery tickets based on the purchased amount
    - [] Validate each tickets contains 6 unique random numbers
        - Throw an `IllegalArgumentException` if the value is out of range
    - [] Validate each number must be between 1 and 45
        - Throw an `IllegalArgumentException` if the value is out of range
- [] Validate winning numbers and the bonus number are unique
    - Throw an `IllegalArgumentException` if they are duplicated
- [] Calculate result statistics
    - [] Compare how many numbers match
- [] Calculate profit rate
    - [] Formula: Total Prize Money / Lottery Purchase Amount
    - [] Round to the nearest tenth

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
