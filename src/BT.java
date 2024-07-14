import java.util.Scanner;

class Node {
    String key;
    Node left;
    Node right;

    public Node(String newNode) {
        key = newNode;
        left = null;
        right = null;
    }
}
  
///////////////////////////////////////////////////
  
class BinaryTree {
    Node root;
  
    public void traverseLeft(Node node) {
        if (node != null) {
            traverseLeft(node.left);
            System.out.print(node.key + " ");
            traverseLeft(node.right);
        }
    }
    
    public void traverseRight(Node node) {
        if (node != null) {
            traverseRight(node.right);
            System.out.print(node.key + " " );
            traverseRight(node.left);
        }
    }
    
    public void traverseParentLeft(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");    
            traverseParentLeft(node.left);
            traverseParentLeft(node.right);
        }
    }
    
    public void traverseParentRight(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            traverseParentRight(node.right);
            traverseParentRight(node.left);
        }
    }
}
  
/////////////////////////////////////////////////////

public class BT {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] command = input.split(" ");
        
        BinaryTree tree = new BinaryTree();
    
        tree.root = new Node(command[1]);
        tree.root.left = new Node(command[2]);
        tree.root.right = new Node(command[3]);
        tree.root.left.left = new Node(command[4]);
        tree.root.left.right = new Node(command[5]);
        tree.root.right.left = new Node(command[6]);
        tree.root.right.right = new Node(command[7]);
        
        if(command[0].equals("left")) {
            tree.traverseLeft(tree.root);
        } else if(command[0].equals("right")) {
            tree.traverseRight(tree.root);
        } else if(command[0].equals("Pleft")) {
            tree.traverseParentLeft(tree.root);
        } else if(command[0].equals("Pright")) {
            tree.traverseParentRight(tree.root);
        } else {
            System.out.println("Invalid traversal type!");
        }

        sc.close();
    }
}