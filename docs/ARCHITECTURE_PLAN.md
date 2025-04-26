# Architecture Plan

- We can not change the package of `Lotto` class

# Define each module
### 1. `lotto` (base package)
- **Lotto.kt**
  - plan to make `getNumbers()`, `countMatching()`

### 2. `lotto.controller`
- **LottoController.kt**

### 3. `lotto.service`
- **LottoService.kt**

### 4. `lotto.model`
- ** WinningNumbers.kt**
- ** MatchResult.kt**

### 5. `lotto.view`
- ** InputView.kt **
- ** OutputView.kt **

### 6. `lotto.util`
- ** Rule.kt **
- ** Validator.kt **
- ** PrizeRank.kt **

### 7. `lotto.exception`
- ** ExceptionMessage.kt **