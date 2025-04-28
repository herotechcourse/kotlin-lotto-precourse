# 🔮 Lotto Simulator
![Build](https://img.shields.io/badge/build-in--progress-green)
![Test](https://img.shields.io/badge/test-in--progress-green) <br>
![Language](https://img.shields.io/badge/language-Kotlin-blue)
![Version](https://img.shields.io/badge/version-1.0.0-blue)
![Docs](https://img.shields.io/badge/docs-up--to--date-blue)<br>
![Commit Style](https://img.shields.io/badge/commit_style-Angular-orange)
![Code Style](https://img.shields.io/badge/code_style-Kotlin_Convention-7F52FF)

## 📝 Table of Contents
- [📌 Program Summary](#-program-summary)
- [🛠️ Development Flow](#-development-flow)
- [📂 Documentation](#-documentation)
- [🏗️ Hierarchy](#-hierarchy)
- [🗂️ Feature List](#-feature-list)
- [🖥 Domain and Service Layer](#-domain-and-service-layer)

---

## 📌 Program Summary
- Implemented a Console-based Lotto simulator<br>
    according to the pre-course mission guidelines.
- Users can purchase lotto tickets and input winning numbers.
- Program provides game results including winning statistics<br>
    and profit rates based on given ranks. 

---

## 🛠️ Development Flow
- Developed with a structured flow to enhance clarity, testability, and maintainability.

    ### 1. **FDD (Feature-Driven Development)**
    - Break the program into `small, testable features` for initial prototype.<br>
    - Easy to develop and test.

    ### 2. **TDD (Test-Driven Development)**
    - Write `tests first` to check that each feature works correctly.

    ### 3. **DDD (Domain-Driven Design)**
    - Consolidate business logic `into domain` models through refactoring.

    ### 4. **MVC + Service layer Refactoring**
    - Organize the code by responsibility following `MVC(S)` pattern. 
    - Apply `DDD` instead of using a simple Model layer.
      - Separate into Controller, Domain, Service, and View layers.

---

## 📂 Documentation
| Title                                                        | Description                                        |
|:-------------------------------------------------------------|:---------------------------------------------------|
| [Project Guidelines](./docs/project-guidelines.md)           | Coding conventions, architecture rules, test, ...  |
| [Functional Requirements](./docs/functional-requirements.md) | Ticket rules, input, matching logic, results       |
| [Execution Flow](./docs/execution-flow.md)                   | Step-by-step flow of UI and service logic          |
| [Action Plan](./docs/action-plan.md)                         | Step-by-step development plan (FDD → TDD → MVC)    |
| [Feature List](./docs/feature-list.md)                       | Core functions broken down by feature              |

---
## 🏗️ Hierarchy
```
lotto/
├── controller/                 # Controller layer
│   └── LottoController.kt
│
├── domain/                     # Domain layer (Core Models)
│   ├── BonusNumber.kt
│   ├── MatchResult.kt
│   ├── PurchaseAmount.kt
│   ├── Rank.kt
│   └── WinningNumbers.kt
│
├── service/                    # Service layer
│   ├── GenerateLottos.kt
│   └── MatchLottos.kt
│
├── view/                       # UI Layer (Input / Output)
│   ├── InputValidator.kt
│   ├── InputView.kt
│   └── OutputView.kt
│
├── Application.kt              # Application entry point
├── Lotto.kt                    # Main Lotto program execution
│
└── archive/                    # Legacy code from FDD/TDD phases
    ├── CalcLottoCount.kt
    ├── CalcProfitRate.kt
    ├── CountByRank.kt
    ├── DetermineRank.kt
    ├── RoundProfitRate.kt
    ├── ValidateAmount.kt
    ├── ValidateLottoNumbers.kt
    ├── ValidateWinningBonus.kt
    └── ValidateWinningMain.kt
```
- Structure reflects feature-based responsibilities.
- Evolved into `MVC + Service` hierarchy during TDD/DDD refactoring. 
- The `archive` folder stores legacy files from FDD/TDD phases for historical reference.
- Business logic is consolidated into the domain layer through DDD refactoring.
- Procedural tasks(e.g., GenerateLottos, MatchLottos) are isolated in the `service layer` for clarity.

---

## 🗂️ Feature List
- ### Detailed Feature Table → [Click here](./docs/feature-list.md)

---

## 🖥 Domain and Service Layer
### Domain Layer
  - **Lotto**
    - Represents a single lotto.
    - It stores and manages 6 unique lotto numbers.
  <br><br>
  - **PurchaseAmount**
    - Represents the total amount of money spent on lotto(s).
    - Calculates how many lottos can be purchased with the given amount.
  <br><br>
  - **WinningNumbers**
    - Represents the 6 winning numbers.
    - Stores and manages the 6 winning numbers for the lotto.
  <br><br>
  - **BonusNumber**
    - Represents the bonus number.
    - Stores and manages 1 bonus number.
  <br><br>
  - **Rank**
    - Defines the ranking system.
    - Calculates ranks based on the number of matched numbers and bonus number.
  <br><br>
  - **MatchResult**
    - Represents the results of multiple lottos.
    - Calculates the number of lotto per rank, total prize money, and profit rate.

### Service Layer
  - **generateLottos**
    - Role
      - Generates random lotto numbers and returns a list of Lotto objects.
    - Returns
      - A list of generated Lotto objects that will be passed to `matchLottos()`.
<br><br>
  - **matchLottos**:
    - Role
      - Compares each lotto with the winning numbers
      - Creates a list of Rank objects based on the matching results.
    - Returns
      - A list of Rank objects that will be passed to `MatchResult`.