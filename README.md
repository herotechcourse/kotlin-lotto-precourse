# kotlin-lotto-precourse

## Feature List

- Input Handling
    - Accept user input for purchase amount
    - Accept user input for last week's winning numbers
    - Accept user input for bonus number

- Ticket Generation
    - Generate lottery tickets based on purchase amount
    - Determine six unique random numbers (range 1-45) for each ticket

- Result Calculation
    - Compare tickets with last week's winning numbers
    - Classify each ticket according to matching numbers and bonus number
    - Calculate prize money and return rate

- Output Display
    - Display purchased tickets
    - Display winning statistics
    - Display total return rate

- Exception Handling
    - Validate all user inputs
    - Provide clear error messages

## Class Description
- **Lotto**: Represents a lottery ticket with six unique numbers (1–45), providing methods to count matches, check for specific numbers, and retrieve sorted numbers.
- **LottoGenerator**: Generates random lottery tickets with six unique numbers using `Randoms` from the `missionutils` library.
- **LottoGrade**: An enum defining lottery prize grades (FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE) based on match count and bonus number, with prize amounts.
- **LottoMachine**: Manages ticket generation based on purchase amount and calculates results by comparing tickets against winning numbers and a bonus number.
- **LottoResult**: Stores result statistics (rank counts) and calculates total prize money and return rate.

## Run a specific test method (example for LottoTest):
```bash
./gradlew test --tests "lotto.LottoTest"
```