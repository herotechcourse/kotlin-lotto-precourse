# Lotto

Hero Tech Course 2025 Precourse Week 2 Mission

## Features

### Execution Flow

1. `InputView` gets user input
* Input values: `Purchase Amount`, `Winning Numbers`, `Bonus Numbers`
* Right after each user input, `InputView` requests `Validator` for validation of the input value.
* During each step, if validation fails, `InputView` dsiplays error message and repeats the step.
* Validation criteria
  | name              | <div style="width:290px">criteria</div> |
  | ----------------- | --------------------------------------- |
  | `Purchase Amount` | - Leading and tailing spaces are ignored. (But *not* the spaces *inside* the number!)<br>- Must *not* contain any non-digit characters.<br>- Must be in the range:<br>&nbsp;&nbsp;&nbsp;&nbsp;`const.MIN_AMOUNT`(default: `const.TICKET_PRICE`(default: 1000)) <= n <= `Int.MAX_VALUE`(= 2,147,483,647)<br>- Must be a multiple of `const.TICKET_PRICE`. |
  | `Winning Numbers` | - Numbers must be separated by `const.DELIMITER_LOTTO_NUMBERS`(default: ",").<br>- Leading and tailing spaces, and spaces around the delimiter are ignored.<br>&nbsp;&nbsp;(But *not* the spaces *inside* each number!)<br>- The number of the numbers must be `const.NUMBER_OF_LOTTO_NUMBERS`(default: 6).<br>- Each number must *not* contain any non-digit characters.<br>- Each number must be in the range:<br>&nbsp;&nbsp;&nbsp;&nbsp;`const.MIN_LOTTO_NUMBER`(default: 1) <= n <= `const.MAX_LOTTO_NUMBER`(default: 45)<br>- All numbers must be unique; no identical numbers. |
  | `Bonus Numbers`    | - Numbers (if more than one) must be separated by `const.DELIMITER_LOTTO_NUMBERS`(default: ",").<br>- Leading and tailing spaces, and spaces around the delimiter are ignored.<br>&nbsp;&nbsp;(But *not* the spaces *inside* each number!)<br>- The number of the numbers must be `const.NUMBER_OF_BONUS_NUMBERS`(default: 1).<br>- Each number must *not* contain any non-digit characters.<br>- Each number must be in the range:<br>&nbsp;&nbsp;&nbsp;&nbsp;`const.MIN_LOTTO_NUMBER`(default: 1) <= n <= `const.MAX_LOTTO_NUMBER`(default: 45)<br>- All numbers must be unique; no identical numbers.<br>- All numbers must be different from any of `Winning Numbers`. |
