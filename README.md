## Feature List

1. **Ticket Purchase**
    - Enter purchase amount (must be a multiple of 1,000 KRW)
    - Calculate number of tickets and display a purchase summary
   

2. **Lotto Ticket Generation**
    - Each ticket consists of 6 unique numbers from 1 to 45
    - Sort numbers within each ticket
    - Inject `Randoms.pickUniqueNumbersInRange(1, 45, 6)` for deterministic testing
   

3. **Result Input**
    - Enter 6 winning numbers (validate uniqueness and range)
    - Enter a bonus number (separate validation)
   

4. **Prize Calculation**
    - Compare each ticket against the winning numbers
    - Determine rank (1–5) based on matches + bonus
    - Aggregate statistics across all tickets
   

5. **Statistics Output**
    - Print the count of winning tickets by category
    - Calculate return rate and round to one decimal place
    - Format output with clear section headings
   

6. **Error Handling**
    - Re‑prompt the user on invalid input
    - Throw `IllegalArgumentException` with a `[ERROR]` prefix
