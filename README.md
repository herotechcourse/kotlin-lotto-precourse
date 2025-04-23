# kotlin-lotto-precourse
# Lotto 
A simple lottery ticket simulator written in Kotlin. This application allows users to purchase lottery tickets, enter winning numbers, and see their results.
## Features

- Purchase lottery tickets with a specified amount (must be divisible by 1,000 KRW)
- Generate random lottery tickets with 6 unique numbers between 1-45
- Enter winning numbers and a bonus number
- Compare purchased tickets with winning numbers
- Calculate and display statistics for winnings and return rate
- Validate user input to ensure it meets all requirements

## Project Structure

src/
├── main/kotlin/lotto/
│   ├── Application.kt             
│   ├── Lotto.kt                   # Core Lotto class
│   ├── LottoMachine.kt            # Logic for lottery operations
│   ├── LottoResult.kt             # Class for prize rankings   
│   ├── InputView.kt               # Handles user input
│   ├── OutputView.kt              # Handles user input
│   ├── OutputView.kt              # Displays output to the user
│   └── Validator.kt               # Input validation
│                  
│
└── test/kotlin/lotto/
    ├── ApplicationTest.kt         # Integration tests
    ├── LottoTest.kt               # Unit tests for Lotto class
    ├── LottoMachineTest.kt        # Unit tests for LottoMachine
    ├── LottoResultTest.kt         # Unit tests for LottoResult
    │── ValidatorTest.kt           # Unit tests for Validator