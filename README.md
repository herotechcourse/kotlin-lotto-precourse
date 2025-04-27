# kotlin-lotto-precourse
## Table of Contents
- [Features](#features)
    - [Input Handling](#input-handling)
    - [Lotto Generation](#lotto-generation)
    - [Prize Calculation](#prize-calculation)
- [Checklist](#checklist)
    - [Mandatory Requirements](#mandatory-requirements)
    - [Testing](#testing)
    - [Code Quality](#code-quality)
    - [Forbidden](#forbidden)
- [Project Structure](#project-structure)

## Features
#### Input Handling
- [x] Use `Console.readLine()` to receive input
- [x] Purchase amount validation (1,000+ KRW, divisible by 1,000)
- [x] Winning numbers validation (6 unique 1-45, comma-separated)
- [x] Bonus number validation (1-45, not in winning numbers)
- [x] Handle invalid input properly: 
  - throw `IllegalArgumentException`
  - display error messages
  - re-prompt from same step

#### Lotto Generation
- [x] Display the correct ticket count (price/1000)
- [x] Use `Randoms.pickUniqueNumbersInRange(1, 45, 6)` 
- [x] Numbers sorted ascending

#### Prize Calculation
- [ ] 5-tier prize system with exact match criteria
- [ ] Bonus number considered for 2nd prize
- [ ] Profit rate to 1 decimal (62.5%, ...)

## Checklist
#### Mandatory Requirements
- [ ] Uses provided `Lotto` class
  - Do not modify the declaration `class Lotto(private val numbers: List<Int>)`
  - Add helper functions below the block `init{}`
- [ ] Main class in `Application.kt`
- [ ] Proper formatting

#### Testing
- [ ] Pass all tests: ./gradlew clean test
- [ ] Write unit tests for all logic, except for UI interactions (reference: `LottoTest`)
  - [ ] Boundary cases:
      - [ ] Minimum purchase (1000 KRW)
      - [ ] All numbers matched
      - [ ] Zero matches
  - [ ] Money calculation precision

#### Code Quality
- [ ] Max 2 indentation levels
- [ ] Small Functions: ≤10 lines, do only one thing
- [ ] Early return pattern (no `else`)
- [ ] Immutable data classes (`val` over `var`) : Kotlin's official style guide
- [ ] Separate business logic from UI logic
- [ ] InputView/OutputView separation
- [ ] Enum class for prize ranks

#### Forbidden
- [ ] No System.exit()/exitProcess()
- [ ] No Java code
- [ ] No generic Exception handling
- [ ] No package/class restructuring
- [ ] No build.gradle modifications

## Project Structure
*(`[x]` for writing/completed, `[ ]` for planned.)*

##### controller (Application Flow Controller: input -> process -> output)
- [x] **`LottoController.kt`**

##### domain (Core Business Logic)
- [x] **`Lotto.kt`** 
- [x] **`LottoMachine.kt`** 
- [x] **`WinningLotto.kt`** 
- [x] **`BonusNumber.kt`** 
- [ ] **`Rank.kt`**
- [ ] **`ResultCalculator.kt`**  

##### view (User Input & Output)
- [x] **`InputView.kt`**  
- [x] **`OutputView.kt`**  

