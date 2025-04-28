# kotlin-lotto-precourse

This is the Week 2 mission of the Hero Tech Course Pre-course: Lotto Console Application.  
Users can purchase multiple lotto tickets based on their input amount, enter the previous week's winning numbers and bonus number, and receive the winning statistics and total return rate.
<br>

## Feature List - Lotto

---

### 1. Enter Purchase Amount
- [x] Users input a total purchase amount : `Money`
- [x] The amount must be a **positive integer** and **a multiple of 1,000**.
- [X] If the amount is invalid, `Money` throws an `IllegalArgumentException.
  - Error format: `[ERROR] Invalid purchase amount.`

---

### 2. Generate Lotto Tickets Automatically
- [x] Based on the purchase amount, generate one ticket for every 1,000 won : `LottoGenerator`
- [x] Each ticket must consist of six **unique** numbers ranging from 1 to 45 : `Lotto`(a single ticket), `LottoNumber`(a valid number)
- [x] Multiple `Lotto` tickets are bundled together in a collection : `LottoTickets`
- [x] The generated numbers are sorted in ascending order before being displayed.

---

### 3. Input Winning Numbers
- [x] Users input **6 numbers**, separated by commas. : `WinningNumbers`
- [x] All numbers must be **between 1 and 45** and **must not contain duplicates**.
- [x] `WinningNumbers.of()` validates the input and creates a value object of 6 numbers. Each number is wrapped with `LottoNumber`.
- [x] Throws an error if:
  - The number of inputs is not 6
  - There are duplicates
  - Numbers are not within 1–45
- Error format: `[ERROR] Invalid winning numbers.`

---

### 4. Input Bonus Number
- [x] Users input a single bonus number. : `BonusNumber`
- [x] It must be between 1 and 45 and must not duplicate any of the winning numbers.
- [x] Throws an error if the bonus number is invalid or duplicated.
- Error format: `[ERROR] Invalid bonus number.`

---


### 5. Evaluate a Single Ticket (Rank)
- [x] Each ticket is compared with the winning numbers to count how many match : `Rank` 
- [x] Whether the ticket includes the bonus number is also checked
- [x] Rank is determined based on match count and bonus number match
  - `Rank` is an `enum` that maps the number of matches and bonus inclusion to the prize tier
  - The `Rank.NONE` is returned if matches are less than 3

---

### 6. Evaluate All Tickets & Count Statistics
- [x] All purchased tickets are evaluated one by one.
- [x] Each ticket is matched against the winning numbers and the bonus number : `LottoRankEvaluator`.
- [x] Ranks are aggregated in a `Map<Rank, Int>` to count the number of tickets per rank.
---

### 7. Calculate Profit Rate
- [x] Calculates the return rate using: `totalPrize / purchaseAmount * 100` : `ProfitCalculator`
- [x] Rounded to one decimal place using `String.format("%.1f", value)`
- [x] Throws an error if the purchase amount is zero or less
- [x] Example output: `Total return rate is 62.5%.`

---

### 8. Output Format
- [x] Lotto ticket numbers are printed one per line, sorted in ascending order and enclosed in square brackets : `OutputView`.
- [x] Winning statistics are printed with the exact match count, bonus ball notation (+ Bonus Ball for 5 matches), prize amount formatted with commas, and ticket count.
- [x] Profit rate is rounded to one decimal place and printed as: Total return rate is XX.X%.
---

### 9. Error Handling
- [ ] All error messages must begin with `[ERROR]`.
- [ ] Use only `IllegalArgumentException` or `IllegalStateException`.
- [ ] Catching generic `Exception` is not allowed.
- [ ] Declare all messages in `Constants.kt` or a central constants object for reuse.

---
### 10. Testing & Coding Conventions
- [ ] All business logic must be testable using **JUnit 5** and **AssertJ**.
- [ ] UI-related logic (`InputView`, `OutputView`) should not be tested.
- [ ] Follow Kotlin coding conventions:
- Functions must do **one thing only**.
- Avoid `else` statements.
- Keep functions **under 10 lines**.
- Limit **indentation to 2 levels**.
