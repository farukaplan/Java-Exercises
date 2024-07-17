import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Node {
    private String name;
    private double price;

    public Node(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public void setPrice(double decreaseAmount) { price -= decreaseAmount; }
}


public class Heap {
    private HashSet<String> productNames;
    private Node[] heap;
    private int size;

    public Heap() {
        heap = new Node[20];
        size = 0;
        productNames = new HashSet<>();
    }

    public void process(String line) {
        String[] split = line.split(" ");

        switch(split[0]) {
            case "ListMin" : if(size != 0) {
                System.out.printf("%s with price %.2f listed.\n", listMin().getName(), listMin().getPrice());
            } else {
                System.out.println("Error, no item added yet.");
            }
            break;

            case "RemoveMin" : if(size == 0) {
                System.out.println("Error, no item added yet.");
            } else {
                Node minNode = removeMin();

                while(minNode != null ){
                    System.out.println(minNode.getName() + " is removed since it has the min price");
                    minNode = compare(minNode);
                }
            }
            break;

            case "Add" : if (!productNames.contains(split[1])) {
                add(split[1], Double.parseDouble(split[2]));
                System.out.println(split[1] + " with price " + split[2] + " added");
            } else {
                System.out.println("Error, there is product with the same name already exists.");
            }
            break;

            case "DecreasePrice" : if(productNames.contains(split[1])) {
                decreasePrice(split[1], Double.parseDouble(split[2]));
                System.out.println(split[1] + "'s price is decreased by " + split[2]);
            } else {
                System.out.println("Error, no item added yet.");
            }
            break;

            default : System.out.println("Error, no valid operation!");
        }
    }

    // Operation methods
    public Node listMin() { return heap[0]; } // O(1) time complexity

    public Node removeMin() { // O(logn) time complexity
        int index = 0;

        Node minNode = heap[0];
        productNames.remove(heap[0].getName());
        heap[0] = heap[size - 1];
        size--;

        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && heap[getRightChildIndex(index)].getPrice() < heap[getLeftChildIndex(index)].getPrice()) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heap[index].getPrice() < heap[smallerChildIndex].getPrice()) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }

        return minNode;
    }

    public Node compare(Node node) {
        if(heap[0].getPrice() == node.getPrice()){
            Node temp = heap[0];
            removeMin();
            return temp;
        }
        return null;
    }

    public void add(String name, double price) { // O(logn) time complexity
        Node node = new Node(name, price);

        if (size == heap.length) {
            heap = Arrays.copyOf(heap, 2 * heap.length);
        }

        int index = size;
        heap[index] = node;
        size++;

        while (index > 0 && heap[getParentIndex(index)].getPrice() > heap[index].getPrice()) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }

        productNames.add(name);
    }

    public void decreasePrice(String name, double decreasePrice) { // O(logn) time complexity
        int index = findIndex(name);

        if (index == -1) {
            System.out.println("Error, no item added yet.");
            return;
        }

        heap[index].setPrice(decreasePrice);

        while (index > 0 && heap[getParentIndex(index)].getPrice() > heap[index].getPrice()) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    // Adjustment methods
    public int findIndex(String productName) {
        for (int i = 0; i < size; i++) {
            if (heap[i].getName().equals(productName)) {
                return i;
            }
        }
        return -1;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}


// Driver for Heap class
class BinaryHeapDriver {
    public static void main(String[] args) {
        Heap heap = new Heap();

        try {
            File file = new File("data/process.txt");
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                heap.process(line);
            }

            scan.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
