# kotlin-lotto-precourse
# Lotto 
A simple lottery ticket simulator written in Kotlin. This application allows users to purchase lottery tickets, enter winning numbers, and see their results.

## Features
### Purchase Lottery Tickets
- Enter the amount you want to spend (must be divisible by 1,000 KRW)
- Receive lottery tickets based on your budget (1,000 KRW per ticket)
- View all your purchased tickets with randomly generated numbers

### Random Number Generation
- Each ticket contains 6 unique numbers between 1 and 45
- Numbers are randomly generated and sorted in ascending order for display

### Winning Number Entry
Enter 6 unique winning numbers (comma-separated)
Enter a separate bonus number for determining 2nd place winners
Full validation for all inputs with clear error messages

### Results Processing

- Automatic comparison of all purchased tickets against winning numbers
- Classification into 5 prize ranks based on matching numbers:
    - 1st Prize (6 matches): 2,000,000,000 KRW
    - 2nd Prize (5 matches + bonus): 30,000,000 KRW
    - 3rd Prize (5 matches): 1,500,000 KRW
    - 4th Prize (4 matches): 50,000 KRW
    - 5th Prize (3 matches): 5,000 KRW

### Statistics and Analysis
- Display of all winning tickets by prize rank
- Count of tickets in each prize category
- Calculation of total winnings and return rate

## Project Structure

src/
├── main/kotlin/lotto/
│   ├── Application.kt             
│   ├── Lotto.kt                   # Core Lotto class
│   ├── LottoMachine.kt            # Logic for lottery operations
│   ├── LottoResult.kt             # Class for prize rankings   
│   ├── InputView.kt               # Handles user input
│   ├── OutputView.kt              # Displays output to the user
│   └── Validator.kt               # Input validation
│                  
│
└── test/kotlin/lotto/
    ├── ApplicationTest.kt         # Integration tests
    ├── LottoTest.kt               # Unit tests for Lotto class
    ├── LottoMachineTest.kt        # Unit tests for LottoMachine
    ├── LottoResultTest.kt         # Unit tests for LottoResult
    └── ValidatorTest.kt           # Unit tests for Validator