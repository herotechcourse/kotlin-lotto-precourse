# Lotto (kotlin)
## Functional Requirements
### Input
- purchase amount
    - divisible by 1,000
- winning numbers: comma-separated (,)
    - 6 unique numbers
    - numbers 1 ~ 45
- bonus number
- invalid input → throw `IllegalArgumentException` and re-prompt

### Rules
- 1,000 KRW = 1 ticket
- ticket = 6 unique random numbers (1~45)
- after purchase:
    - input winning numbers
    - input bonus number
- matching rules:
    - 6 matches → 1st Prize (2,000,000,000 KRW)
    - 5 matches + bonus → 2nd Prize (30,000,000 KRW)
    - 5 matches → 3rd Prize (1,500,000 KRW)
    - 4 matches → 4th Prize (50,000 KRW)
    - 3 matches → 5th Prize (5,000 KRW)

### Output
- purchased ticket numbers (sorted ascending)
- match results (count per prize rank)
- total profit rate (rounded to nearest 0.1%)

## Programming Rules
- Kotlin 1.9.24
- only use Randoms, Console APIs
- no `System.exit()`, no exitProcess()
- keep function ≤ 10 lines
- avoid `else` when possible
- use Enum for prize ranks
- separate UI (InputView/OutputView) from logic
- unit test all logic (except input/output)

---
## Project Structure

- lotto
    - controller
        - LottoController.kt  
    - model
        - Lotto.kt            
        - LottoTickets.kt     
        - WinningNumbers.kt   
        - Rank.kt             
    - service
        - LottoService.kt     
    - view
        - InputView.kt        
        - OutputView.kt       
    - util
        - RandomUtil.kt       
        - ValidationUtil.kt   
        - ProfitCalculator.kt
    - exception
        - InputValidationException.kt  
