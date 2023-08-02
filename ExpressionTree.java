// Name: Faruk
// Surname: KAPLAN
// Student ID: 21050111026

import java.util.Scanner;
import java.util.Stack;

public class ExpressionTree extends LinkedBinaryTree{
    LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
    Stack<Node<String>> stack = new Stack<>();
    Stack<Node<String>> stackCopy = new Stack<>();
    int counter = 0;
    
    // Constructor, constructs tree
    /*
     * ALGORİTHM EXPLANATİON:
     * Split the expression, put them in an array from right to left (start reading the end of the expression)
     * if split equals binary and unary operand or operator, create node and push it onto stack
     * if split equals ")", just pass it
     * if split equals "(" check the peek element. 
     * if peek is not unary, pop the 3 element from stack, connect them with the middle element and push the middle onto stack.
     * if peek is unary, pop the 2 element from stack, and check peek again
     * if peek is operator and has no child, connect two popped element and push first popped element onto stack
     * if peek is operand, push last popped element onto stack again, pop 2 element from stack, connect them again and push the 
     * operator onto stack again
     */
    public ExpressionTree(String expr) {
        String[] splitExpr = expr.split(" ");
        int start = 0, end = splitExpr.length - 1;

        while (start < end) {
            String temp = splitExpr[start];
            splitExpr[start] = splitExpr[end];
            splitExpr[end] = temp;
            start++;
            end--;
        }

        for(String split : splitExpr) {
            if(isOperator(split)) {
                Node<String> operatorNode = createNode(split, null ,null, null);
                stack.push(operatorNode);
            } else if(isTrig(split)) {
                Node<String> trigNode = createNode(split, null ,null, null);
                stack.push(trigNode);
            } else if(isOperand(split)) {
                Node<String> operandNode = createNode(split, null ,null, null);
                stack.push(operandNode);
            }  else if(split.equals("(")) {
                if(isTrig(stack.peek().getElement())) {
                    Node<String> trigNode = stack.pop();
                    Node<String> trigOperand = stack.pop();

                    if(stack.isEmpty()) {
                        trigNode.setLeft(trigOperand);
                        trigOperand.setParent(trigNode);
                        stack.push(trigNode);
                        continue;
                    }             

                    if(!isOperand(stack.peek().getElement()) && (stack.peek().getLeft() == null)) {
                        trigNode.setLeft(trigOperand);
                        trigOperand.setParent(trigNode);
                        stack.push(trigNode);
                    } else {
                        stack.push(trigOperand);

                        if (stack.size() < 2) {
                            throw new IllegalArgumentException("Not enough element in the stack!");
                        }

                        Node<String> operator = stack.pop();
                        Node<String> rightOperand = stack.pop();

                        operator.setLeft(trigNode);
                        operator.setRight(rightOperand);
                        rightOperand.setParent(operator);
                        trigNode.setParent(operator);

                        stack.push(operator);
                    }
                } else {
                    if (stack.size() < 3) {
                        throw new IllegalArgumentException("Not enough element in the stack!");
                    }
    
                    Node<String> leftOperand = stack.pop();
                    Node<String> operator = stack.pop();
                    Node<String> rightOperand = stack.pop();
    
                    operator.setLeft(leftOperand);
                    operator.setRight(rightOperand);
                    rightOperand.setParent(operator);
                    leftOperand.setParent(operator);
    
                    stack.push(operator);
                } 
            } else {
                continue;
            }
        }
        stackCopy.addAll(stack);
    }

    // toString() and originExpr() methods for returning original expression
    public String toString() {
        StringBuilder sb = new StringBuilder();
        originExpr(stack.pop(), sb);
        return sb.toString();
    }
    
    private void originExpr(Node<String> node, StringBuilder sb) {
        if (node == null) {
            return; 
        }
    
        if (isOperator(node.getElement()) || isTrig(node.getElement())) {
            counter++;
            sb.append("(");
        }

        originExpr(node.getLeft(), sb);
        if(isTrig(node.getElement())) {
            sb.insert(counter - 5, node.getElement());
            counter+=4;
        } else {
            counter++;
            sb.append(node.getElement());
        }
        originExpr(node.getRight(), sb);
    
        if (isOperator(node.getElement()) || isTrig(node.getElement())) {
            counter++;
            sb.append(")");         
        }

        stack.push(node);
    }
   
    //evaluate() and other methods for returning result of the given expresion
    public int evaluate(String xvalue) {
        if(stack.isEmpty()) {
            throw new IllegalStateException("Tree is empty!");
        }

        return evaluateTree(stack.pop(), xvalue); 
    }

    private int evaluateTree(Node<String> node, String value) {
        String element = node.getElement();
        stack.push(node);

        if(isOperator(element)) {
            int leftOperand = evaluateTree(node.getLeft(), value);
            int rightOperand = evaluateTree(node.getRight(), value);
            return operatorProcessor(element, leftOperand, rightOperand);
        } else if(isTrig(element)) {
            int operand = evaluateTree(node.getLeft(), value);
            return trigProcessor(element, operand);
        } else {
            if(element.matches("[A-Za-z]+")) {
                return Integer.parseInt(value);
            } else {
                return Integer.parseInt(element);
            }
        }
    }

    private int operatorProcessor(String operator, int leftOperand, int rightOperand) {
        switch(operator) {
            case "+" : return leftOperand + rightOperand;
            case "-" : return leftOperand - rightOperand;
            case "*" : return leftOperand * rightOperand;
            case "/" : 
            if(rightOperand == 0) {
                throw new ArithmeticException("Division by zero!");
            }
            return leftOperand / rightOperand;
            default : throw new IllegalArgumentException("Invalid operator -> " + operator);
        }
    }

    private int trigProcessor(String trig, int operand) {
        double radian = Math.toRadians(operand);
        switch(trig) {
            case "sin" : return (int)Math.sin(radian);
            case "cos" : return (int)Math.cos(radian);
            default : throw new IllegalArgumentException("Invalid trig. function -> " + trig);
        }
    }

    // displayTree() and displayInorderTraversal() methods for displaying the expression tree
    public void displayTree() {
        displayInorderTraversal(stackCopy.pop(), 0);
    }

    private void displayInorderTraversal(Node<String> node, int depth) {
        if (node == null) {
            return;
        }
    
        displayInorderTraversal(node.getLeft(), depth + 1);
    
        for (int i = 0; i < depth; i++) {
            System.out.print(". ");
        }
        
        if (isOperator(node.getElement())) {
            System.out.println(node.getElement());
        } else {
            System.out.println(node.getElement());
        }
    
        displayInorderTraversal(node.getRight(), depth + 1);
    }

    // Classification methods
    public boolean isOperator(String argument) {
        return argument.equals("+") || argument.equals("-") || argument.equals("*") 
        || argument.equals("/");
    }

    public boolean isTrig(String argument) {
        return argument.equals("sin") || argument.equals("cos");
    }

    public boolean isOperand(String argument) {
        try {
            Integer.parseInt(argument);
            return true; 
        } catch (NumberFormatException e) {}
        try {
            Double.parseDouble(argument);
            return true; 
        } catch (NumberFormatException e) {}
        
        if (Character.isLetter(argument.charAt(0))) {
            return true; 
        }
        
        return false; 
    }
}


// Test program to test all methods
class ExpresionTreeDriver {
    public static void main(String[] args) {
        String xValue = "0"; // default, for expressions with no x-variable

        // These 6 tests does not contain x-variable.
        System.out.println();
        ExpressionTree expressionTree1 = new ExpressionTree("( 4 + ( 5 * 7 ) )");

        System.out.println("Infix Expression: " + expressionTree1.toString());
        System.out.println("Evaluation Result: " + expressionTree1.evaluate(xValue));
        System.out.println("Expression Tree:"); expressionTree1.displayTree();


        System.out.println();
        ExpressionTree expressionTree2 = new ExpressionTree("( ( 4 * 5 ) + ( 33 / 3 ) )");
    
        System.out.println("Infix Expression: " + expressionTree2.toString());
        System.out.println("Evaluation Result: " + expressionTree2.evaluate(xValue));
        System.out.println("Expression Tree:"); expressionTree2.displayTree();


        System.out.println();
        ExpressionTree expressionTree3 = new ExpressionTree("( ( sin ( 45 * 6 ) ) + ( 7 + 128 ) )");
    
        System.out.println("Infix Expression: " + expressionTree3.toString());
        System.out.println("Evaluation Result: " + expressionTree3.evaluate(xValue));
        System.out.println("Expression Tree:"); expressionTree3.displayTree();


        System.out.println();
        ExpressionTree expressionTree4 = new ExpressionTree("( ( cos ( 90 * 4 ) ) + ( sin ( 15 * 6 ) ) )");
    
        System.out.println("Infix Expression: " + expressionTree4.toString());
        System.out.println("Evaluation Result: " + expressionTree4.evaluate(xValue));
        System.out.println("Expression Tree:"); expressionTree4.displayTree();


        // These 2 tests contain x-variable
        System.out.println();
        
        ExpressionTree expressionTree5 = new ExpressionTree("( ( X * 7 ) + ( 13 * 5 ) )");
        System.out.println("Infix Expression: " + expressionTree5.toString());

        Scanner scan1 = new Scanner(System.in);
        System.out.printf("ENTER THE 1st X-VALUE: ");
        String xvalue1 = scan1.nextLine();

        System.out.println("Evaluation Result: " + expressionTree5.evaluate(xvalue1));
        System.out.println("Expression Tree:"); expressionTree5.displayTree();


        System.out.println();
        
        ExpressionTree expressionTree6 = new ExpressionTree("( ( sin ( X * 1 ) ) + 60 )");
        System.out.println("Infix Expression: " + expressionTree6.toString());

        Scanner scan2 = new Scanner(System.in);
        System.out.printf("ENTER THE 2nd X-VALUE (Value should be 90 and multiples for exact result): ");
        String xvalue2 = scan2.nextLine();

        System.out.println("Evaluation Result: " + expressionTree6.evaluate(xvalue2));
        System.out.println("Expression Tree:"); expressionTree6.displayTree();

        scan1.close();
        scan2.close();
    }
}