# Feature List

## 🎯 Goal
Break down the project into testable, modular features based on **`FDD`**.<br>
Implement each feature using **`TDD`** to ensure stability and clarity.<br>
All components are refactored according to the **`MVC + S`** pattern.

## 👾 Features by Module
### 🧩 1. Purchase Flow
[`Execution Flow (1 - 4)`](./execution-flow.md#1-consoleoutput)

| Feature | Description | Red | Green |                 Refactored                  | Done |
|:---|:---|:---:|:---:|:-------------------------------------------:|:---:|
| promptAmount | Print request message for purchase amount | ❌ | ❌ |                      **InputView.printPurchaseAmountMessage()**                      | ✅ |
| inputAmount | Read input(purchase amount) from user | ❌ | ❌ |                      **Moved to InputView.readPurchaseAmount()**                      | ✅ |
| validateAmount | Must be num, ≥ `1,000` | ✅ | ✅ |        **PurchaseAmount.validate()**        | ✅ |
| calcLottoCount | `nLotto = Amount / 1000` | ✅ | ✅ | **PurchaseAmount.countPurchasableLottos()** | ✅ |
| generateLottos | Each with `6` unique numbers | ✅ | ✅ |           **Moved to service layer**            | ✅ |
| validateLottoNumbers | Duplicates or out-of-range | ✅ | ✅ |                      **Lotto.validate()**                       | ✅ |

### 🧩 2. Lotto Printing
[`Execution Flow (5)`](./execution-flow.md#5-consoleoutput)

| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| printLottoCount | Print number of issued lottos | ❌ | ❌ | **OutputView.printLottoCount()** | ✅ |
| printLottoNumbers | Print each lotto's 6 numbers in brackets, sorted | ❌ | ❌ | **OutputView.printLottoNumbers()** | ✅ |

### 🧩 3. Winning Number Input
[`Execution Flow (6-8)`](./execution-flow.md#6-consoleoutput)

| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| promptWinningMain | Print request message for `6ea` winning numbers | ❌ | ❌ | **InputView.printWinningMainMessage()** | ✅ |
| inputWinningMain | Read input for `6ea` winning numbers from user | ❌ | ❌ | **Moved to InputView.readWinningNumbers()** | ✅ |
| validateWinningMain | Must be `1-45`, no duplicates | ✅ | ✅ | **WinningNumbers.validate()** | ✅ |

### 🧩 4. Bonus Number Input
[`Execution Flow (9-11)`](./execution-flow.md#9-consoleoutput)

| Feature | Description | Red | Green |         Refactored         | Done |
|:---|:---|:---:|:---:|:--------------------------:|:---:|
| promptWinningBonus | Print request message for `1ea` bonus number | ❌ | ❌ |             **InputView.printWinningBonusMessage()**              | ✅ |
| inputWinningBonus | Read input for `1ea` bonus number | ❌ | ❌ |             **Moved to InputView.readBonusNumber()**              | ✅ |
| validateWinningBonus | Must be `1-45`, not in main numbers | ✅ | ✅ | **BonusNumber.validate()** | ✅ |

### 🧩 5. Lotto Result Calculation
[`Execution Flow (12)`](./execution-flow.md#12-calculate)

| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| matchLottos | Match each lotto to winning numbers | ✅ | ✅ | **Moved to service layer** | ✅ |
| determineRank | Determine rank based on match count | ✅ | ✅ | **Rank.determine()** | ✅ |
| countByRank | Count lottos per prize category | ✅ | ✅ | **MatchResult.getCount()** | ✅ |
| calcProfitRate | Calculate `profit = prize / purchase` | ✅ | ✅ | **MatchResult.calcProfitRate()** | ✅ |
| roundProfitRate | Round to `1` decimal place | ✅ | ✅ | **MatchResult.roundProfitRate()** | ✅ |

### 🧩 6. Final Result Printing
[`Execution Flow (13-14)`](./execution-flow.md#13-consoleoutput)

| Feature | Description | Red | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| printStats | Print lotto result statistics | ❌ | ❌ | **OutputView.printStats()** | ✅ |
| printProfitRate | Print total return rate `X.X%` | ❌ | ❌ | **OutputView.printProfitRate()** | ✅ |

### Option for status columns <br>
✅ : Finished<br>
⏳ : In progress<br>
—  : Not started yet or not applicable <br>
❌ : UI I/O features are excluded from unit tests by rule.
ℹ️ : Not tested directly, but logic is covered by unit tests.