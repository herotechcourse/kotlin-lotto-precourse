# kotlin-lotto-precourse

This is the Week 2 mission of the Hero Tech Course Pre-course: Lotto Console Application.  
Users can purchase multiple lotto tickets based on their input amount, enter the previous week's winning numbers and bonus number, and receive the winning statistics and total return rate.
<br>

## Feature List - Lotto

---

### 1. Enter Purchase Amount
- [x] Users input a total purchase amount : `Money`
- [x] The amount must be a **positive integer** and **a multiple of 1,000**.
- [X] Throws an IllegalArgumentException if invalid.
  - Error format: `[ERROR] Invalid purchase amount.`

---

### 2. Generate Lotto Tickets Automatically
- [x] Based on the purchase amount, one ticket is generated for every 1,000 won : `LottoGenerator`
- [x] Each ticket consists of 6 unique numbers ranging from 1 to 45 : `Lotto`, `LottoNumber`
- [x] Tickets are bundled into a collection : `LottoTickets`
- [x] Numbers are sorted in ascending order when displayed

---

### 3. Input Winning Numbers
- [x] Users input **6 numbers**, separated by commas. : `WinningNumbers`
- [x] All numbers must be **between 1 and 45** and **No duplicates allowed**
- [x] Throws an IllegalArgumentException if invalid
  - Error format: `[ERROR] Invalid winning numbers.`

---

### 4. Input Bonus Number
- [x] Users input a single bonus number. : `BonusNumber`
- [x] It must be between 1 and 45 and not overlap with winning numbers
- [x] Throws an IllegalArgumentException if invalid
  - Error format: `[ERROR] Invalid bonus number.`

---

### 5. Evaluate a Single Ticket (Rank)
- [x] Each ticket is compared with the winning numbers : `Rank` 
- [x] Determines prize rank based on result
- [x] If fewer than 3 numbers match, Rank.NONE is assigned
---

### 6. Evaluate All Tickets & Count Statistics
- [x] All purchased tickets are evaluated.
- [x] Tickets are matched against winning numbers and bonus number : `LottoRankEvaluator`
- [x] Ranks are aggregated into Map<Rank, Int>
---

### 7. Calculate Profit Rate
- [x] Calculates the return rate using: `totalPrize / purchaseAmount * 100` : `ProfitCalculator`
- [x] Result is rounded to one decimal place using String.format("%.1f", value)
- [x] Throws an error if purchase amount is zero or less

---

### 8. Output Format
- [x] Lotto ticket numbers are printed one per line, enclosed in square brackets [ ], and sorted in ascending order : `OutputView`.
- [x] Winning statistics are printed in the exact required format:
  - Matches + Bonus Ball notation (for 5 matches with bonus)
  - Prize amount formatted with commas
  - Number of winning tickets
- [x] Profit rate is printed as:
  - Total return rate is XX.X%.

---

### 9. Error Handling
- [X] All error messages must start with [ERROR]
- [X] Only IllegalArgumentException or IllegalStateException can be thrown
- [X] Do not catch generic Exception
- [X] All error messages are declared in Constants.kt.

---