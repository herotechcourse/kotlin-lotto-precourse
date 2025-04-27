# kotlin-lotto-precourse
# Lotto Ticket Machine

## Features
- Receives the purchase amount from the user and calculates the number of tickets to issue.
- Issues lottery tickets, each containing 6 unique random numbers sorted in ascending order.
- Receives last week's winning numbers and a bonus number from the user.
- Compares the issued tickets with the winning numbers to determine the winning ranks.
- Prints the lottery result statistics based on the number of matches.
- Calculates and prints the total return rate, rounded to one decimal place.
- Displays an [ERROR] message and re-prompts the user if invalid input is provided.

## How to Run
1. Make sure Kotlin 1.9.24 is installed and configured.
2. Clone the repository.
3. Run the following command in the terminal:
    - For Windows: `.\gradlew.bat clean test`
    - For macOS/Linux: `./gradlew clean test`
4. Confirm that all tests pass with "BUILD SUCCESSFUL".

