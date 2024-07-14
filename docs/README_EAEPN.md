# Evaluating Arithmetic Expressions in Postfix Notation

In here, we implemented Stack ADT to evaluate arithmetic expressions consisting of operands and operators in postfix notation.

Properties are as follows:

- Function takes a single parameter; a string which can consist of a single command or multiple commands separated with space characters.
- The commands consist of operands and operators in postfix notation.
- When the user sends an integer(s) as a command, push that integer(s) onto the stack.
- When the user enters a valid operator (+, -, *, /, %) as a command, pop two integers off the stack, perform the requested operation, and then push the result back onto the stack. Note: If the user enters / to perform division, then make sure the division is the integer division (not floating point). Be careful about the order of numbers and analyze the sample outputs.
- When the user enters print, add the current state of the stack with the exact form of the output to the result of your function. The content of the stack should be in brackets. If there are more than 1 item there should be a comma and space after each item until the end. Analyze the sample outputs.
- When the user enters pop as a command, pop the top element off the stack and add only that element (not the entire stack) to the result of your function.
- When the user enters exit as a command, add $ sign to the result of your function.

There are a number of error conditions our program must consider:

- If the user enters an operator other than the 5 operators given above, then our program should ignore it but should not stop and an “Invalid operator” message should be added to the result of our function.
- If the user enters a valid operator, however, there are no integers in the stack or there is only one integer in the stack, then our program adds a warning message “Not enough integers in the stack” and should ignore the operation.

Sample input and outputs are given in the testCases.txt file.