# Bank-guru-selenium-test
An automation test framework with full test cases demo on a banking project.

The framework contain 5 levels:
- Actions: this will have some package.
    - *Commons action* that can use in the page objects package.
    - *Abstract test* is use in the Test cases level.
    - *Global Constants* is all the variables can use in the global scale.
    - *AbstractUI* for some cases' locator is repeated then we can use it dynamically.
    - *Page Generator Manager* whenever instantiate the driver then do it with this class.
- Interfaces
  - Contains all UI element of the pages.
- Resources
  - Place to group test cases by testing type and executed by the testNG XML files.
- Test cases
  - Hold the test cases can run independently and give them testing type tag name that can execute on Resources level
- Test data
  - Contains all the data tests of the Test cases level.