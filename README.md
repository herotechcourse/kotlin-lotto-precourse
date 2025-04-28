# kotlin-lotto-precourse
# Lotto Game

## 🚀 Project Introduction

This is a simple console-based Lotto game where the user purchases lotto tickets, inputs winning numbers and a bonus ball, and calculates the return rate based on the result.

This project is implemented in Kotlin and utilizes the `camp.nextstep.edu.missionutils` library for random number generation and console input handling.

## ✨ Features

Here is a list of the implemented features. Each feature is managed by a separate Git commit following the AngularJS commit conventions.

-   **[feature] Input Purchase Amount:**
    -   Accepts the amount of money to purchase Lotto tickets.
    -   1 ticket = 1000 KRW.

-   **[feature] Generate Lotto Tickets:**
    -   Automatically generates 6 unique random numbers per ticket within the range 1–45.

-   **[feature] Input Winning Numbers:**
    -   Accepts 6 unique numbers separated by commas.

-   **[feature] Input Bonus Ball:**
    -   Accepts a single bonus ball number separately.

-   **[feature] Validate Inputs:**
    -   Purchase amount must be a positive integer and a multiple of 1000.
    -   Lotto numbers must be 6 unique integers between 1 and 45.
    -   Bonus ball must be between 1 and 45 and not duplicate a winning number.

-   **[feature] Match Results:**
    -   Checks how many numbers each ticket matches with the winning numbers.
    -   Special case: 5 matches + bonus ball.

-   **[feature] Output Match Statistics:**
    -   Displays how many tickets matched each prize condition.
    -   Prize conditions: 3 matches (5,000 KRW), 4 matches (50,000 KRW), 5 matches (1,500,000 KRW), 5+bonus (30,000,000 KRW), 6 matches (2,000,000,000 KRW).

-   **[feature] Calculate Return Rate:**
    -   Calculates and prints the total return rate based on prizes won.

-   **[feature] Exception Handling:**
    -   Throws `IllegalArgumentException` for invalid inputs and prints an error message without abruptly terminating the application.

-   **[feature] Write Test Code:**
    -   Use JUnit 5 and AssertJ for unit tests.
    -   Use `mission-utils` test library to simulate random value generation and console input.

## ✅ Requirements

-   Kotlin 1.9.24
-   Gradle
-   `camp.nextstep.edu.missionutils` library (provided)

## 🛠️ How to Run

1.  **Build the Project:**
    ```
    ./gradlew build
    ```
    Or on Windows:
    ```
    gradlew.bat build
    ```
2.  **Run the Application:**
    -   Execute the `main` function in `src/main/kotlin/lotto/Application.kt` via your IDE.
    -   Alternatively, configure and run the generated JAR file if desired.

## 🧪 How to Test

Run all tests in the project to ensure that the functionality works correctly.

-   **macOS / Linux:**
    ```
    ./gradlew clean test
    ```
-   **Windows:**
    ```
    gradlew.bat clean test
    ```
    or
    ```
    .\gradlew.bat clean test
    ```

After running the tests, you should see successful test results.
