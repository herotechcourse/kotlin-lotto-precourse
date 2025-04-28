# Execution-flow
## Before Refactoring
[🏁 Legacy Execytuib Flow (for initial FDD/TDD)](./execution-flow-legacy.md)

## After Refactoring
```
1. Display input prompt (purchase amount)
    -> OutputView.promptPurchaseAmount()

2. User inputs amount → Validate
    -> InputView.readPurchaseAmount()
    -> InputValidator.validatePurchaseAmount()

3. Generate lottery tickets → Display tickets
    -> GenerateLottos.generate()
    -> OutputView.printPurchaseLottos()

4. Display input prompt (winning numbers)
    -> OutputView.promptWinningNumbers()

5. User inputs winning numbers → Validate
    -> InputView.readWinningNumbers()
    -> InputValidator.validateWinningNumbers()

6. Display input prompt (bonus number)
    -> OutputView.promptBonusNumber()

7. User inputs bonus number → Validate
    -> InputView.readBonusNumber()
    -> InputValidator.validateBonusNumber()

8. Match tickets with winning numbers
    -> matchLottos(lottos, winningNumbers, bonusNumber)

9. Calculate ranks and profit rate
    -> MatchResult(ranks)
    -> MatchResult.profitRate(purchaseAmount.value())

10. Display result (winning statistics & profit rate)
    -> OutputView.printMatchResult(matchResult)
    -> OutputView.printProfitRate(profitRate)
```
- All input validations throw exceptions with `[ERROR]` messages and re-prompt input.
- Profit rate calculation is rounded to two decimal places, displayed up to one decimal place.