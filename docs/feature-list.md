# Feature List

## 🎯 Goal
Break down the project into testable, modular features based on **`FDD`**.<br>
Implement each feature using **`TDD`** to ensure stability and clarity.<br>
All components are refactored according to the **`MVC + SR`** pattern.

## 👾 Features by Module
### 🧩 1. Purchase Flow
[`Execution Flow (1 - 4)`](./execution-flow.md#1-consoleoutput)
| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| promptAmount | Print request message for purchase amount | ❌ | ❌ | — | — |
| inputAmount | Read input(purchase amount) from user | ❌ | ❌ | — | — |
| validateAmount | Must be num, ≥ `1,000` | ⏳ | — | — | — |
| calcLottoCount | `nLotto = Amount / 1000` | ⏳ | — | — | — |
| generateLottos | Each with `6` unique numbers | ⏳ | — | — | — |
| handleLottoError | Duplicates or out-of-range | ⏳ | — | — | — |

### 🧩 2. Lotto Printing
[`Execution Flow (5)`](./execution-flow.md#5-consoleoutput)
| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| printLottoCount | Print number of issued lottos | ❌ | ❌ | — | — |
| printLottoNumbers | Print each lotto's 6 numbers in brackets, sorted | ❌ | ❌ | — | — |

### 🧩 3. Winning Number Input
[`Execution Flow (6-8)`](./execution-flow.md#6-consoleoutput)
| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| promptWinningMain | Print request message for `6ea` winning numbers | ❌ | ❌ | — | — |
| inputWinningMain | Read input for `6ea` winning numbers from user | ❌ | ❌ | — | — |
| validateWinningMain | Must be `1-45`, no duplicates | ⏳ | — | — | — |

### 🧩 4. Bonus Number Input
[`Execution Flow (9-11)`](./execution-flow.md#9-consoleoutput)
| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| promptWinningBonus | Print request message for `1ea` bonus number | ❌ | ❌ | — | — |
| inputWinningBonus | Read input for `1ea` bonus number | ❌ | ❌ | — | — |
| validateWinningBonus | Must be `1-45`, not in main numbers | ⏳ | — | — | — |

### 🧩 5. Lotto Result Calculation
[`Execution Flow (12)`](./execution-flow.md#12-calculate)
| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| matchLottos | Match each lotto to winning numbers | ⏳ | — | — | — |
| determineRank | Determine rank based on match count | ⏳ | — | — | — |
| countByRank | Count lottos per prize category | ⏳ | — | — | — |
| calcProfitRate | Calculate `profit = prize / purchase` | ⏳ | — | — | — |
| roundProfitRate | Round to `1` decimal place | ⏳ | — | — | — |

### 🧩 6. Final Result Printing
[`Execution Flow (13-14)`](./execution-flow.md#13-consoleoutput)
| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| printStats | Print lotto result statistics | ❌ | ❌ | — | — |
| printProfitRate | Print total return rate `X.X%` | ❌ | ❌ | — | — |

### Option for status columns <br>
✅ : Finished<br>
⏳ : In progress<br>
—  : Not started yet or not applicable <br>
❌ : UI I/O features are excluded from unit tests by rule.
ℹ️ : Not tested directly, but logic is covered by unit tests.