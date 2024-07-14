import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() { return data; }

    public Node getLeft() { return left; }

    public Node getRight() { return right; }

    public void setLeft(Node newLeft) { left = newLeft; }

    public void setRight(Node newRight) { right = newRight; }
}

////////////////////////////////////

class BinarySearchTree {
    private Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRecursive(root, data);
    }

    Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.getData()) {
            root.setLeft(insertRecursive(root.getLeft(), data));
        } else if (data >= root.getData()) {
            root.setRight(insertRecursive(root.getRight(), data));
        }

        return root;
    }

    void inorder() {
        inorderRecursive(root);
    }

    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.getLeft());
            System.out.print(root.getData() + " ");
            inorderRecursive(root.getRight());
        }
    }

    void printLeaves() {
        printLeavesRecursive(root);
        System.out.println();
    }

    void printLeavesRecursive(Node root) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null){
                System.out.print(root.getData() + " ");
            }
            
            printLeavesRecursive(root.getLeft());
            printLeavesRecursive(root.getRight());
        }
    }
    
     public void printPathsToLeaves() {
        List<Integer> path = new ArrayList<>();
        PathsToLeavesRecursive(root, path);
    }

    
    private void PathsToLeavesRecursive(Node node, List<Integer> path) {
        if (node == null) {
            return;
        }
        
        path.add(node.getData());
        
        if (node.getLeft() == null && node.getRight() == null) {
            System.out.println(path);
        } else {
            PathsToLeavesRecursive(node.getLeft(), path);
            PathsToLeavesRecursive(node.getRight(), path);
        }
    
        path.remove(path.size() - 1); // do not edit this line (removes the current node's (last) value)                             
    }  
}

//////////////////////////////////////////////////////
     
public class Lab8 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        
        String mode = sc.nextLine();
        int[] tree_arr = new int[10];
        
        for (int i = 0; i < 10; i++) {
            if (sc.hasNextInt()) {
                tree_arr[i] = sc.nextInt();
            }
        }                          
        
        for (int i = 0; i < 10; i++) {
            tree.insert(tree_arr[i]);
        }
            
        if (mode.equals("inorder")) {
        System.out.println("Inorder traversal: "); tree.inorder();
        } else if (mode.equals("leaf")) {
        System.out.println("Leaf Nodes: "); tree.printLeaves();
        } else if (mode.equals("path")) {
        System.out.println("Path to each leaf: "); tree.printPathsToLeaves();
        } 

        sc.close();
    }
}
