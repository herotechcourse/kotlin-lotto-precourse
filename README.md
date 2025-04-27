# kotlin-lotto-precourse


## Planned Features

### 1. Purchase Tickets
- The user inputs a purchase amount.
- The amount must be divisible by **1,000 KRW**.
- Issue as many tickets as the budget allows (1,000 KRW per ticket).

### 2. Generate Lottery Tickets
- Each ticket contains **6 unique random numbers**.
- Numbers must be in the range **1 to 45**.
- Tickets are displayed sorted in ascending order.

### 3. Input Winning Numbers
- Prompt the user to input **last week's winning numbers** (6 unique numbers).
- Prompt the user to input a **bonus number** (must not duplicate any winning numbers).

### 4. Prize Evaluation
- Match the purchased tickets against the winning numbers and bonus number.
- **Prize Ranks and Rewards**:
    -  1st Prize: Match 6 numbers → **2,000,000,000 KRW**
    -  1st Prize: Match 6 numbers → **2,000,000,000 KRW**
    -  2nd Prize: Match 5 numbers + bonus → **30,000,000 KRW**
    -  3rd Prize: Match 5 numbers → **1,500,000 KRW**
    - ️ 4th Prize: Match 4 numbers → **50,000 KRW**
    - ️ 5th Prize: Match 3 numbers → **5,000 KRW**

### 5. Display Results
- Show the number of tickets matching each prize rank.
- Calculate and display the **total profit rate**, rounded to **one decimal place**.

### 6. Error Handling
- Throw and handle specific exceptions:
    - `IllegalArgumentException` for invalid user input (e.g., invalid number range, incorrect format).
    - `IllegalStateException` for illegal program states (if necessary).
- All error messages must start with `[ERROR]`.
- If the user inputs invalid data, the program **must re-prompt** only for that input.

---

## 📌 Notes
- **Strict validation** for user inputs is required.
- **Do not** catch generic `Exception`. Only catch **specific exceptions** like `IllegalArgumentException` and `IllegalStateException`.
- Focus on clean, maintainable, and modular code structure.

