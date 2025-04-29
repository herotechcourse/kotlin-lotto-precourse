# kotlin-lotto-precourse

# Lotto Game

A simple command-line Lotto simulator written in Kotlin.

## Features

- Purchase Lotto tickets by entering amount (1 ticket = 1,000 KRW)
- Auto-generate 6 random numbers per ticket (1–45, no duplicates)
- Input last week's winning numbers + bonus number
- Compare each ticket against winning numbers
- Calculate winning statistics and return rate
- Handle invalid inputs with proper error messages
- Follow strict output format

## Requirements

- Kotlin 1.9.24
- Use `camp.nextstep.edu.missionutils.Randoms` and `Console`
- Max 2 levels of indentation
- Each function must be under 10 lines
- Follow Kotlin Coding Conventions
- No `else`, no generic exceptions
- Separate domain and UI logic

## How to Run

```bash
./gradlew clean test  # macOS/Linux
gradlew.bat clean test # Windows
```

You should see:
```nginx
BUILD SUCCESSFUL
```