# kotlin-lotto-precourse

# Lottery Ticket Machine

A straightforward command-line application that simulates a lottery ticket vending machine with comprehensive input validation and prize determination.

## Key Features

- Buy multiple lottery tickets at 1,000 KRW each
- Each ticket contains 6 distinct numbers ranging from 1 to 45
- Enter last week's winning numbers along with a bonus number
- Automatically calculates prizes based on matching numbers and bonus
- Robust input validation with informative error feedback

## Development Approach

1. **Domain Design**
   - Created core entities such as `Lotto`
   - Utilized Kotlin `enum class` to represent prize tiers and their rewards

2. **Input Validation**
   - Enforced rules for:
      - Purchase amount (must be positive and divisible by 1,000)
      - Ticket numbers (unique and within valid range)
      - Winning numbers (unique and valid)
      - Bonus number (distinct from winning numbers and valid)

3. **Core Logic Implementation**
   - Generated tickets with unique random numbers
   - Determined prize ranks based on matched numbers and bonus presence

4. **Separation of Concerns**
   - Encapsulated all user input/output in `InputView` and `OutputView`
   - Kept business logic free from UI code

5. **Testing Strategy**
   - Developed thorough unit tests covering all core logic and validations
   - Excluded tests for direct user input/output operations

## Usage Instructions

1. Launch the program by running the `main()` function.
2. Input the amount you want to spend on tickets.
3. Provide the winning numbers and the bonus number as prompted.
4. Review your tickets and the calculated return rate.

## Commit Message Style

- Adheres to [Conventional Commits](https://www.conventionalcommits.org/) guidelines, for example:  
  `test: add unit tests for Lotto validation`

---