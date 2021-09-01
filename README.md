# marialourdes-pollicar
Proposed test cases
- End to end screnario of adding income and expense then checking of balance if it is correct
- Verify income and expense entires are added in balance window
- Transfer from one account(cash) to another(card) to verify if transfers are logged

Automation Framework Overview 
- Page Object Model to separate the page objects and actions from the test to make code reusable and maintenance easier.
- Maven to manage builds that are used
- TestNG to prioritize test cases and makes the code reusable
- IntelliJ IDE aided for easier development through intellisense
- Appium as server and element inspector
- Android studio to emulate android device

Approach
Create a framework using Page Object model to have a reusable code and make maintenance easier. 
Config.xml is also created to easily update general configurations like the Desired Capabilities. 
Enums are used to avoid erroneous entries in reused methods.
Pom.xml which utilizes Maven is set to containt all project dependencies
