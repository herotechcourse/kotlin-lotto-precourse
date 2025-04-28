# Kotlin Lotto Precourse

## Feature List

### 1. Input Handling
- Purchase Amount Prompt & Validator
    - Valid: number > 0 and divisible by 1000
- Winning Numbers Prompt & Validator
    - Valid: exactly 6 unique Integer ∈ [1…45]
- Bonus Number Prompt & Validator
    - Valid: Integer ∈ [1…45] and not among the winning numbers
- Error Handling
    - Handle error and input rules for invalid input

### 2. Ticket Generation & Management
- Calculate ticket count from purchase amount
- Generate unique numbers for tickets

### 3. Prize Evaluation & Statistics
- Ticket Rank Evaluator
    - Compare each `Lotto` vs. winning set + bonus → `Rank`
- Statistics Aggregator

### 4. Presentation & Output
- Ticket Count Display
- Ticket List Display
- Lottery Result Statistics Display
- Profit Rate Display
