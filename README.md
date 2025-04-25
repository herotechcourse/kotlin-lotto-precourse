# kotlin-lotto-precourse

## Feature List

1. Input validation for purchase amount (must be divisible by 1,000)
2. Generate lottery tickets (each ticket has 6 unique numbers between 1 and 45)
3. Display issued tickets (sorted)
4. Accept winning numbers (6 unique numbers) and a bonus number
5. Compare tickets to winning numbers and determine prize ranks
6. Calculate and display winning statistics and total return rate
7. Re-prompt on invalid input with proper error messages
8. Follow Kotlin coding conventions and low nesting (≤ 2 levels)
9. Unit tests using JUnit 5 and AssertJ (excluding UI logic)

### step 1: Initialise the application entry point
- `fun main()` is the standard entry point in kotlin
- `LottoGame().run()` creates an instance of the game and runs it.