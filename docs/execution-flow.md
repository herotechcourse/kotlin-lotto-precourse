# Execution-flow
## Before Refactoring
[🏁 Legacy Execytuib Flow (for initial FDD/TDD)](./execution-flow-legacy.md)

## After Refactoring
```
1. Display input prompt (purchase amount)

2. User inputs amount → Validate

3. Generate lottery tickets → Display tickets

4. Display input prompt (winning numbers)

5. User inputs winning numbers → Validate

6. Display input prompt (bonus number)

7. User inputs bonus number → Validate

8. Match tickets with winning numbers

9. Calculate ranks and profit rate

10. Display result (winning statistics & profit rate)
```
- All input validations throw exceptions with `[ERROR]` messages and re-prompt input.
- Profit rate calculation is rounded to two decimal places, displayed up to one decimal place.