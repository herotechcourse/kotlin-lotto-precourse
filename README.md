# kotlin-lotto-precourse

This is the Week 2 mission of the Hero Tech Course Pre-course: Lotto Console Application.  
Users can purchase multiple lotto tickets based on their input amount, enter the previous week's winning numbers and bonus number, and receive the winning statistics and total return rate.
<br>

## Feature List - Lotto

---

### 1. Enter Purchase Amount
- [ ] Users can input the total purchase amount.
- [ ] The amount must be a **positive integer** and **a multiple of 1,000**.
- [ ] If the input is less than 1,000, not a number, or not divisible by 1,000, an error message is shown and the user is prompted again.
  - Error format: `[ERROR] Invalid purchase amount.`

---

### 2. Generate Lotto Tickets Automatically
- [x] Based on the purchase amount, generate one ticket for every 1,000 won : `LottoGenerator`
- [x] Each ticket must consist of six **unique** numbers ranging from 1 to 45 : `Lotto`(a single ticket), `LottoNumber`(a valid number)
- [x] Multiple `Lotto` tickets are bundled together in a collection : `LottoTickets`
- [x] The generated numbers are sorted in ascending order before being displayed.

---

### 3. Input Winning Numbers
- [ ] Users input **6 numbers**, separated by commas.
- [ ] All numbers must be **between 1 and 45** and **must not contain duplicates**.
- [ ] If the input is malformed, contains duplicates, or includes numbers out of range, an error is shown and the user is prompted again.
- Error format: `[ERROR] Invalid winning numbers.`

---

### 4. Input Bonus Number
- [ ] Users input **a single bonus number**.
- [ ] It must be **between 1 and 45** and must **not duplicate any of the winning numbers**.
- [ ] If the bonus number is invalid or duplicated, an error is shown and the user is prompted again.
- Error format: `[ERROR] Invalid bonus number.`

---


### 5. Evaluate a Single Ticket (Rank)
- [ ] Each ticket is compared with the winning numbers to count how many match.
- [ ] Whether the ticket includes the bonus number is also checked.
- [ ] A rank is assigned based on the following criteria:

| Rank | Match Condition                   | Prize |
|------|------------------------------------|--------|
| 1st  | Matches all 6 numbers              | ₩2,000,000,000 |
| 2nd  | Matches 5 + Bonus number           | ₩30,000,000 |
| 3rd  | Matches 5                          | ₩1,500,000 |
| 4th  | Matches 4                          | ₩50,000 |
| 5th  | Matches 3                          | ₩5,000 |


---

### 6. Evaluate All Tickets & Count Statistics
- [ ] All purchased tickets are evaluated one by one.
- [ ] Each ticket is assigned a rank using `LottoRankEvaluator`.
- [ ] A summary of winning results is collected using `Map<Rank, Int>`.

---

### 7. Calculate Profit Rate
- [ ] Calculate the return rate using: `totalPrize / purchaseAmount * 100`.
- [ ] Round to one decimal place.
- [ ] Example output: `Total return rate is 62.5%.`

---

### 8. Output Format
- [ ] Lotto numbers are printed in `[1, 2, 3, 4, 5, 6]` format.
- [ ] The number of tickets, winning statistics, and profit rate are printed in the exact format specified in the example output.
- [ ] **If the format does not match**, the score will be **zero**.

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
