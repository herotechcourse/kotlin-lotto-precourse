# kotlin-lotto-precourse

## 🏗  Project Structure

```
[Application]
       │
       ▼
[LottoController]
       │
       ├────────────────┬─────────────────┐
       ▼                ▼                 ▼
   [Model]           [View]          [DTOs]
    │                 │                │
    ├── Game         ├── InputView    ├── BonusNumberDto
    ├── Lotto        ├── OutputView   ├── LottoTicketDto
    ├── WinningLotto                  ├── MatchResultDto
    └── LottoTicketMachine            ├── PurchaseAmountDto
                                      └── WinningNumbersDto 
```

I designed Model-View-Controller architecture. I used DTOs to transfer data from layer-to-layer.

<br>

## 🎯 Key Components

<img width="400" alt="image" src="https://github.com/user-attachments/assets/cae7d96f-035b-403c-a2a1-15136166ae70" />


### 🎟️ Lotto

```kotlin
class Lotto(private val numbers: List<Int>)
```
- Represents a single lotto ticket
- Contains 6 unique numbers between 1 and 45
- Validates the numbers to ensure they meet lotto rules
- Provides methods for number comparison and matching

### 🏆 WinningLotto

```kotlin
class WinningLotto(private val numbers: List<Int>, private val bonusNumber: Int)
```
- Represents the winning numbers for a draw
- Contains 6 main numbers and 1 bonus number
- Validates that bonus number is not in the main numbers
- Determines the rank of matching tickets

### 🎰 LottoTicketMachine

```kotlin
class LottoTicketMachine(private val amount: Int)
```
- Handles the purchase of lotto tickets
- Calculates the number of tickets based on purchase amount
- Generates random numbers for each ticket
- Ensures each ticket has unique numbers


### 🎮 Game

```kotlin
class Game(private val lottoTickets: List<Lotto>, private val winningLotto: WinningLotto)
```
- Represents the main game logic of the Lotto application
- Manages the collection of purchased lotto tickets
- Handles the comparison between tickets and winning numbers
- Calculates the final results and statistics


### 🎯 Rank (Enum)

```kotlin
enum class Rank(val matchCount: Int, val hasBonus: Boolean, val prize: Int)
```
- Defines the possible winning ranks in the lotto game
- Specifies the number of matches and bonus number requirement
- Associates each rank with its corresponding prize money
- Used for determining the final results 

<br>


## ✅ Functional Requirements

# kotlin-lotto-precourse

- [x] Lotto
    - [x] 1,000KRW 
    - [x] 6 unique random numbers
        - [x] 1~45   
- [x] WinningLotto
    - [x] Lotto
    - [x] Bonus Number
- [x] Rank
    - [x] rank
    - [x] matchCount, isBonusNumberRequired
    - [x] price
- [x] Lotto Ticket Machine
  - [x] buy Lotto 
- [x] Game
  - [x] Lotto Ticket
  - [x] Winning Lotto
  - [x] match lotto ticket, winning lotto and get a result <Rank, Lotto>
  - [x] profit
- [x] InputView
  - [x] ask purchase amount
  - [x] ask bonus number
  - [x] ask winning number


- [x] re-prompt input from that step
  - [x] use a single lambda for input operations   
- [x] print prize with comma(,) - StringFormat
- [x] sort lotto number
- [x] % format
- [x] bonus ball format
- [x] separate controller logic
- [x] separate Lotto Machine with Interface
- [x] add test code
- [x] check requirement
- [x] bonus number can't be duplicate with existing winning lotto numbers

<br>

## ✨ What I Considered

### 1. HashMap vs EnumMap

- Compared difference of HashMap and EnumMap
- EnumMap is based on Hash Table, and provide O(1) performances in get/delete operations
- EnumMap strictly limits type of key, it must be an Enum type
- I would allow only Rank type for keys, so I chose EnumMap rather than HashMap

### 2. Declaration Location

- Inside `()` (Primary Constructor):
  ```kotlin
  class Game(
      private val money: Int,
      private val lotto: Lotto
  )
  ```
  - Must specify parameter types
  - Properties are initialized during object creation
  - Consider potential side-effects from subclasses

- Inside `{}` (Class Body):
  ```kotlin
  class Game {
      private val result: Map<Rank, Int>
      
      init {
          // result initialization
      }
  }
  ```
  - Cannot use constructor parameters directly

<br>

## 🎓 Lessons Learned

### 1. Kotlin Language Specifics

#### Functional Interfaces

```kotlin
fun interface FunctionalInterface {
    fun run()
}
```
- Kotlin's `fun` keyword for functional interfaces
  - Explicitly marks interface as functional
  - Similar to Java's `@FunctionalInterface` annotation
- First-class function support in Kotlin
  - Functions as first-class citizens
  - Often prefer function types over functional interfaces
  - More concise and flexible than interface-based approach

#### String Operations

- Learned the crucial difference between `isNotEmpty()` and `isNotBlank()`:
- `isNotEmpty()`: Returns false for `""`, but true for `" "`
- `isNotBlank()`: Returns false for both `""` and `" "`

#### Syntax Differences from Java

- Using colon (:) syntax instead of Java's implements/extends

### 2. Ternary Operators in Kotlin

- Kotlin doesn't have ternary operators (`?:` in Java)
- Uses `if-else` expressions instead:
  ```kotlin
  // Java ternary
  String result = condition ? "true" : "false";
  
  // Kotlin equivalent
  val result = if (condition) "true" else "false"
  ```

### 3. String.format

#### Decimal formatting
  - `%.1f` formats to one decimal place

```kotlin
// Format to one decimal place
String.format("%.1f", returnRate)

#### Thousand separators
  - `%,d` adds commas for thousands

// Add thousand separators
String.format("%,d", value)
```
