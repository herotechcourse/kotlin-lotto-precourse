# kotlin-lotto-precourse

***
## Functional Requirements
- should be divisible by 1000
- winning numbers & lotto numbers
  - unique
  - range 1 ~ 45
  - size 6
- bonus number
  - not be duplicated with winning numbers
  - range 1 ~ 45
- prize
  -  1st Prize: Match 6 numbers / 2,000,000,000 KRW
  -  2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
  -  3rd Prize: Match 5 numbers / 1,500,000 KRW
  -  4th Prize: Match 4 numbers / 50,000 KRW
  -  5th Prize: Match 3 numbers / 5,000 KRW
- profit rate
- when user inputs wrong, throw IllegalArgumentException and reprompt

***
## Programming Requirements 1
- Use Kotlin 1.9.24
- Use only Kotlin
- entry point is main()
- Not modify build.gradle.kts
- Not use System.exit() & exitProcess()

***
## Programming Requirements 2
- coding convention
- indentation depth must not exceed 2
- functions as small and focused
- focus as possible—each should do only one thing.
- Use JUnit 5 and AssertJ to test

***
## Programming Requirements 3
- Keep functions under 10 lines
- Avoid else
- Use Enum classes
- Separate business logic from UI logic.
- Implement unit tests for all logic, except  

***
# 🧪 Test Cases
## ✅ 1. Winning Lotto
- throw an exception when fewer than 6 numbers are provided for the lotto.
- throw an exception when duplicated winning numbers are given.
- throw an exception when the winning numbers are out of range.

- throw an exception when the bonus number is out of range. 
- throw an exception when the bonus number is duplicated with winning numbers.

## ✅ 2. Lotto
- throw an exception when lotto numbers exceed 6
- throw an exception when lotto numbers contain duplicates
- throw exception when less than 6 numbers are given

## ✅ 3. Lotto Ticket Generator
- should contain numbers only within the range 1 to 45
- should contain exactly 6 numbers
- should not contain duplicate numbers

## ✅ 4. Profit Rate Calculation Tests
- should correctly calculate profit rate based on total purchase and winnings
- should round profit rate correctly when it includes decimal places

***
## Architecture
```
lotto/
├── common/
│   └── Constants.kt            
├── domain/
│   ├── PrizeRank.kt            
│   └── WinningLotto.kt         
├── generator/
│   └── LottoGenerator.kt       
├── io/
│   ├── InputView.kt            
│   └── OutputView.kt           
├── service/
│   ├── LottoResultCalculator.kt
│   └── ProfitCalculator.kt     
├── Application.kt              
└── Lotto.kt                    
```