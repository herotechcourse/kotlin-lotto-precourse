# kotlin-lotto-precourse

## About Project
Implement a simple lottery ticket machine. The brief flow of the machine is below
1. The user enters the purchase amount.
2. The program issues lottery tickets.
3. The user enters the winning numbers and a bonus number.
4. The program compares the user's tickets to the winning numbers and prints the result.

## Planned Features
1. **Input Handling**
    - Read purchase amount
    - Read winning numbers
    - Read a bonus number
2. **Domain Logic**
    - Read inputs and display ticket numbers
    - Compare every ticket to winning numbers and check which criteria the ticket meets
    - Calculate the profit rate
    - Display final result
3. **Output**
    - Display number of tickets and their numbers
    - Display result statistics
    - Display profit rate
    - Display error messages if invalid case happen
4. **Utility**
    - Generate 6 random numbers in range from 1 to 45.
    - Split inputs by comma
5. **Edge Cases(Validation)**
    - Purchase amount must be divisible by 1000.
    - Each winning numbers and bonus number must be int the range from 1 to 45.
    - Throw `IllegalArgumentException` on invalid input

## Project Structure

    Lotto/
    │
    ├── Application.kt
    │
    ├── Lotto
    │
    ├── LottoManager.kt
    │
    ├── controller/
    │   └── LottoController.kt
    │
    ├── input/
    │   └── InputReader.kt
    │
    ├── util/
    │   ├── InputSplitter.kt
    │   └── RandomUtils.kt
    │
    ├── validator/
    │   └── InputValidator.kt
    │
    └── view/
        └── InputView.kt
        └── OutputView.kt

## Project Architecture

This project follows a simple **Model–View–Controller (MVC)** layering:

- **Model** (`Lotto, LottoManager.kt`)
    - `Lotto` and `LottoManager.kt` define the core data structures and business logic.

- **View** (`view/`)
    - `InputView.kt` displays input instructions.
    - `OutputView.kt` displays output numbers of each ticket and final statistics.

- **Controller** (`controller/`)
    - `LottoController.kt` coordinates input reading, invokes the domain logic, and delegates formatting to the view.

Helper packages (`input/`, `util/`, `validator/`) support MVC by providing input routines, utility functions, and validation logic without mixing concerns.