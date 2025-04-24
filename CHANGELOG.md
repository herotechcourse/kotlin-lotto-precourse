# 📌 Changelog

All notable changes to this project will be documented in this file.

---

## [0.1.0] - 2025-04-23

### Added

- Kotlin project structure initialization
- Gradle project setup with Kotlin DSL
- Initial version of the Lottery Ticket App
- Placeholder `main()` function for application entry point
- README with example usage and test instructions

## [0.2.0] - 2025-04-23

### Added

- `PurchaseAmountInputReader` class for purchase amount input

## [0.3.0] - 2025-04-24

### Added

- `PurchaseAmountValidator` class with input number validation and divisibility checks
- Unit tests for `PurchaseAmountValidator` covering all test cases and expected behavior

### Changed

-  Input validation loop in `PurchaseAmountInputReader` to reprompt users on invalid input instead of terminating

## [0.4.0] - 2025-04-24

### Added

- [Optional] `PurchaseAmountDisplay` class to print the entered purchase amount
- Unit tests for `PurchaseAmountDisplay` to verify output formatting and correctness

## [0.5.0] - 2025-04-24

### Added

- `TicketCalculator` class to calculate the number of tickets based on the purchase amount.
- Unit test for `TicketCalculator` to verify correct calculation of tickets.

### Fix

- Adjusted `PurchaseAmountDisplayTest` to proper folder structure

## [0.6.0] - 2025-04-24

### Added

- `TicketGenerator` class to generate multiple lottery tickets with 6 unique random numbers between 1 and 45.
- Unit test for `TicketGenerator` to verify the correct generation of tickets, ensuring each contains 6 unique numbers within the valid range.

### Changes

- `Lotto class` and `LottoTest` were modified to handle validation of the 6 unique numbers and exceptions for invalid inputs.

## [0.7.0] - 2025-04-24

### Added

- Sorted error statement was added in `Lotto Class`.
- New unit test cases for `TicketGenerator` and `Lotto` to ensure generated tickets are sorted.

### Changes

- Updated `TicketGenerator` to return sorted numbers.

## [0.8.0] - 2025-04-24

### Added

- `TicketDisplay` class to print purchased ticket
- Unit tests for `TicketDisplay` to verify output formatting and correctness

## [0.9.0] - 2025-04-24

### Added

- `WinningNumberInputReader` and `BonusNumberInputReader` classes to read last week's winning numbers and the bonus number from user input.

## [0.9.0] - 2025-04-24

### Added

- `BonusNumberInputReader` & `WinningNumberInputReader` class with input number and logic validation
- Unit tests for `BonusNumberValidator` & `WinningNumberValidator` covering all test cases and expected behavior

### Changes

- Added `RangeValidator` as shared object to work with common functions

---

## Notes

- N/A