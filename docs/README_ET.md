# Expression Tree

The goal of this exercise is to implement an ExpressionTree class that represents an arithmetic expression. The leaf nodes store operands and the internal nodes store operators. Binary operators (+),(-),(*), and unary operators (sin) and (cos) are allowed. The operands are either constant numbers (you may assume they are integers) or the variable X.

- The ExpressionTree class MUST extend the LinkedBinaryTree class.
- The constructor of the ExpressionTree class should take a String that contains a fully parenthesized infix expression and construct the corresponding tree. For example (X + (5 ∗ 7)) is a fully parenthesized input whereas 4 + 5 ∗ 7 is not. For simplicity you may assume the parenthesis, the operands and the operators are separated by white space in the input String. ((cos(2 ∗ X)) + (5 ∗ 7)) is an example including a cos.
- In ExpressionTree class, write a toString() method that returns a String containing the expression in infix form. Note that the infix form has to be fully parenthesized. For unary operators, operator appears before operand, e.g. cos X
- In ExpressionTree class, write a method int evaluate(int xvalue) that evaluates the expression stored in the tree for the given value of the variable X, and returns the result.
- In ExpressionTree class, provide a method displayTree() that displays the tree as follows:
    - Nodes should be printed according to their order in an inorder traversal, one node per line.
    - The data for a node should be preceded by depth number of dots, where depth denotes the depth of the node in the tree.

Here is an example output for the tree corresponding to (4 + (5 ∗ 7)):

`.4`  
`+`  
`..5`  
`.*`  
`..7`

- Write a driver program to test all methods of the ExpressionTree class.