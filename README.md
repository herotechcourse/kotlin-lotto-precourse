# Lotto Application

A lottery ticket purchase and winning calculation application implemented in Kotlin.

## Features

- Generate lottery tickets based on purchase amount
- Input winning numbers and bonus number
- Calculate matches and statistics
- Display return on investment rate

## Tech Stack

- Kotlin 1.9.24
- JDK 21
- Gradle 8.7

## Project Structure

```
src/main/kotlin/lotto/
├── Application.kt                 # Main application entry
├── Lotto.kt                       # Core lotto class
├── controller/
│   └── LottoController.kt         # Application controller
├── domain/
│   ├── Prize.kt                   # Prize definition
│   ├── WinningLotto.kt            # Winning lotto class
│   └── WinningResult.kt           # Winning result class
└── view/
    ├── InputView.kt               # User input interface
    └── ResultView.kt              # Result display interface
```

## Code Quality Standards

This project strictly follows these code quality guidelines:
- Maximum 2 indentation levels
- Functions less than 10 lines
- No else statements
- Separation of business and UI logic

## Running the Application

### Using IntelliJ IDEA (Recommended)

1. Open the project in IntelliJ IDEA
2. Navigate to `src/main/kotlin/lotto/Application.kt`
3. Right-click and select "Run 'ApplicationKt'" or click the green run button next to the `main` function
4. Interact with the application in the console window

### Using Executable JAR (Simplest command-line method)

```
./gradlew clean jar
java -jar build/libs/kotlin-lotto-1.0-SNAPSHOT.jar
```

### Using Gradle run task

```
./gradlew run
```

## Running Tests

```
./gradlew test
```

## Example Input/Output

```
Enter the purchase amount:
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
...

Enter the winning numbers (comma-separated):
1,2,3,4,5,6

Enter the bonus number:
7

Winning statistics
---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.
```
