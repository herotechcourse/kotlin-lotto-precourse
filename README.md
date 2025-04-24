# 🔮 Lotto Simulator
![Build](https://img.shields.io/badge/build-in--progress-yellow)
![Test](https://img.shields.io/badge/test-in--progress-yellow) <br>
![Language](https://img.shields.io/badge/language-Kotlin-blue)
![Version](https://img.shields.io/badge/version-1.0.0-blue)
![Docs](https://img.shields.io/badge/docs-up--to--date-blue)<br>
![Commit Style](https://img.shields.io/badge/commit_style-Angular-orange)
![Code Style](https://img.shields.io/badge/code_style-Kotlin_Convention-7F52FF)

## Table of Contents
- [📌 Program Summary](#-program-summary)
- [🛠️ Development Flow](#️-development-flow)
- [📂 Documentation](#-documentation)
- [🏗️ Hierarchy](#-hierarchy)
- [🗂️ Feature List](#-feature-list)
    ### T.B.D.

---

## 📌 Program summary
- Implemented a Console-based Lotto simulator<br>
    according to the pre-course mission guidelines.
- Users purchase lotto tickets and input winning numbers.
- User get statistics and profit rates based on given ranks. 

---

## 🛠️ Development Flow
- Follows a structured development flow designed for<br>
    clarity, testability, and maintainability:

    ### 1. **FDD (Feature-Driven Development)**
    - Break the program into small features<br>
    that are easy to develop and test.

    ### 2. **TDD (Test-Driven Development)**
    - Write tests first to check that each feature works correctly.

    ### 3. **MVC + SR Refactoring**
    - Organize the code by responsibility.
    - Model, View, Controller, Service, Repository.

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

## 🦴Directory Structure for TDD
- It reflects feature-based responsibilities.
- It'll evolve into a full MVC + SR hierarchy as TDD progresses.

```
lotto/
├── domain/                         (1) Core domain logic
│   ├── MatchLottos.kt                  # Match lottos with winning numbers.
│   └── DetermineRank.kt                # Determine prize ranks.

├── service/
│   ├── validation/                 (2) All input validation
│   │   ├── ValidateAmount.kt           # Validate purchase amount.
│   │   ├── ValidateLottoNumbers.kt     # Validate generated lotto numbers.
│   │   ├── ValidateWinningMain.kt      # Validate 6 main winning numbers.
│   │   └── ValidateWinningBonus.kt     # Validate 1 bonus winning number.
│   │
│   └── logic/                      (3) Core business logic (calculation & generation)
│       ├── CalcLottoCount.kt           # Calculate number of purchasable lottos.
│       ├── GenerateLottos.kt           # Generate lottos.
│       ├── CalcProfitRate.kt           # Calculate profit rate.
│       └── CountByRank.kt              # Count matched lottos by rank.

├── util/                           (4) Utility
│   └── RoundProfitRate.kt              # Rounds profit rate to first decimal place.

├── view/                           (5) ⏳ [T.B.D.] UI Layer // Used when refactoring to MVC.

├── controller/                     (6) ⏳ [T.B.D.] Controller // Used when refactoring to MVC.

├── repository/                     (7) No actual DB, but can be introduced if necessary.

└── Application.kt                  (8) Entry point.
```

---

## 🏗️ Hierarchy
## 🗂️ Feature List
- ### Full Feature Table → [Click here](./docs/feature-list.md)