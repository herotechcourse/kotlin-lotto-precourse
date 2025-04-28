## **Programming Requirements**

### **Programming Requirements 1**

- [x] The program must be executable with **Kotlin 1.9.24**.
- [x] You must implement the solution **only in Kotlin**— **Java code is not allowed**.
- [x] The entry point of the application must be the`main()`function in the`Application`class.
- [x] You may **not modify** the`build.gradle.kts`file, and you may **not use any external libraries **other than those
  provided.
- [x] Do **not** use`System.exit()`or`exitProcess()`to terminate the program.
- [x] Unless otherwise specified in the requirements, you may **not rename or move **files, packages, or other project
  elements.

### **Programming Requirements 2**

- [x] Follow the Kotlin Coding Conventions.
- [x] The **indentation depth must not exceed 2**. A maximum of 2 levels is allowed.
- [x] Keep functions as **small and focused**as possible—each should do only **one thing**.
- [x] Use **JUnit 5** and **AssertJ** to test the functionality according to your feature list.

### **Programming Requirements 3**

- [x] Keep functions under 10 lines to ensure they perform a single responsibility.
- [x] Avoid using `else`.
- [x] Use **Enum classes** where applicable.
- [x] Separate business logic from UI logic.
- [ ] Implement unit tests for all logic, except for UI interactions (System.out, System.in).

### **Using Library Requirements**

- [x] You must use the `Randoms` and `Console` APIs provided by the `camp.nextstep.edu.missionutils` package.

- [x] To generate random values, use `Randoms.pickUniqueNumbersInRange()` from `camp.nextstep.edu.missionutils.Randoms`.
- [x] To receive user input, use `Console.readLine()` from `camp.nextstep.edu.missionutils.Console`.

### **Requirements For Using Lotto Class**

- [x] You must implement your program using the provided`Lotto`class.
- [x] You **must not** add any fields (instance variables) to the`Lotto`class other than`numbers`.
- [x] The visibility modifier `private`on`numbers`**must not**be changed.
- [x] You **must not** change the package of the`Lotto`class.
