# Binary Search Tree Exercise

- We want to use the BST structure to sort the given array in ascending order.
- The program should take any 10-length int array input from the user and create a BST from that.
- By traversing the tree with the inorder method, the program should output the sorted version of the given input.
- The program should determine the leaf nodes and print them.
- Finally, the program should find and print all the paths to the leaf nodes.

## Implement the missing parts in Node.java.

- Nodes must have an integer variable to store its data.
- Data is passed in the constructor.
- Nodes must have left and right children of type “Node”.
- Left/right child must be null unless a new child is added.

## Implement the missing parts in BinarySearchTree.java.

BST must have a root of type “Node” and it should be initialized in the constructor as “null”.

- “insert” method calls “insertRecursive” by passing the root of the tree and the data to be added. It takes the data to be added as its parameter.
- “insertRecursive” should instantiate a new node if the current node is root (“null” at first) or a child of a leaf (which is “null”). (if condition #1)
- If the data to be added is smaller than the root data, it should be added as the left child. It should be added as the right otherwise. Also add it as the right if there is an equality. If the left or the right children are the roots of subtrees, it should recursively traverse until it reaches a leaf.(if condition #2 and 3) 
- “inorder” method calls “inorderRecursive” by passing the root of the tree.

“inorderRecursive” should traverse the tree recursively in the following order:
    - Left child or subtree
    - Parent
    - Right child or subtree
and print the elements in this order as shown in the class.

- “printLeaves” method calls the “printLeavesRecursive” by passing the root of the tree.
- “printLeavesRecursive” should traverse the tree recursively strating from the root and print each visited element if both children are null, which indicates that they are leaf nodes.
- “printPathsToLeaves” instantiates a list to save visited nodes and calls “PathsToLeavesRecursive” by passing the root and the path list.
- “PathsToLeavesRecursive “ should add each visited node to the path and print the path when it reaches a node such that its both children are null, which means when it reaches a leaf, similar to printLeavesRecursive.

## Complete Main.java

- The program must have 3 modes:
    - inorder: Prints the constructed tree in inorder fashion. 
    - leaf: Prints the leaves of the tree. 
    - path: Prints the paths to the leaves. 
- Call the methods “inorder”, “printLeaves” and “printPathsToLeaves” according to the mode provided in the first line of the input 
- Second line is the array from which the tree will be constructed.

## Test Cases

Here is an example of a BST (from the class):

-> 10, 8, 20, 1, 9, 15, 25, 12, 16, 24 

```  
     10
    /  \ 
  8     20 
 / \    / \
1   9  15  25
       /\  / 
     12 16 24
```
### Case 1
- Input:
    - inorder
    - 10 8 20 1 9 15 25 12 16 24
- Output:
    - Inorder traversal:
    - 1 8 9 10 12 15 16 20 24 25

### Case 2
- Input:
    - leaf
    - 10 8 20 1 9 15 25 12 16 24
- Output:
    - Leaf Nodes: 
    - 1 9 12 16 24

### Case 3
- Input : 
    - path
    - 10 8 20 1 9 15 25 12 16 24
- Output:
    - Path to each leaf: 
        - [10, 8, 1]
        - [10, 8, 9]
        - [10, 20, 15, 12]
        - [10, 20, 15, 16]
        - [10, 20, 25, 24]