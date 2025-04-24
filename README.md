# kotlin-lotto-precourse

## Feed Back

- Write a Detailed README file
- Don't write class designs, write what functionality should be implemented
    - It could be ambiguous at first, continuously update the list during development
- make .gitignore file, don't inlcude .class files or other non valuable file
- Naming style
    - Use names that reveal intent
    - Don't abbreviate, it's okay to use longer names
    - Don't include type information
- Don't Mix Spaces and Tabs -> Use IDEA feature(disable tab character)
- Use Code Formatting
    - IntelliJ IDEA: ⌥⌘L (Mac), Ctrl+Alt+L (Windows/Linux)

## Take Care (Personal)

- purchase tickets, use every budget (14000 -> 14 tickets (maybe example is wrong)
- Bonus number should be managed differently -> UpperBound (2nd Prize)
- Bonus number only used when it matches 5 number
- Exception could be various -> type matching, input range, duplicate number, not enough input, bonus number
  duplicate ...
- Re-Prompt if Exception occur (IllegalArgumentException)
- Winning rate calculate -> profit/used -> Round to One decimal place
- There is no game over requirement, just make it "One Round"

## Take Care (Formal)

- Keep function 10 lines, perform single responsibility
- Avoid using `else`, early return can eliminate `else`
- Use `Enum` class as it possible
- Separate business logic from UI logic
- Implement unit test, except UI logic

## Features

### Model

- Lotto : Lotto Model
- User: Money, Tickets<Lotto>
- LottoManager: Logic between Lotto and User

### View

- InputView: Responsibility of input
- OutputView: Responsibility of printing

### Utils

- InputValidator: Check validness of input

### Controller

- LottoController: Combine Model, View, Validator

# Functions

## Lotto
- [x] getLottoNumbers: Extension Function, Give 6 random unique numbers

## User
- [x] buyLottoTickets: member method,  purchases lotto tickets within the given budget

## InputView
- [ ] 