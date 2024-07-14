import java.util.Scanner;

class Node {
    private String data;
    private int priority;
    private Node next;

    Node(String data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;    
    }

    public String getData() { return data; }

    public int getPriority() { return priority; }

    public Node getNext() { return next; }

    public void setNext(Node newNext) { next = newNext; } 
}

////////////////////////////////////////

class AlphabetLinkedPQ {
    private Node head;
    private int size;
    private String order;
    
    public AlphabetLinkedPQ(String order) {
        this.head = null;
        this.size = 0;
        this.order = order;
    }

    private int getAlphabeticalIndex(String str) {
        if(order.equals("normal")) {
            return str.charAt(0) - 'a';
        } else if(order.equals("reverse")) {
            return 'z' - str.charAt(0);
        }

        return -1;
    }

    public void enqueue(String chr) {
        System.out.println("Priority:" + getAlphabeticalIndex(chr));
        Node node = new Node(chr, getAlphabeticalIndex(chr));

        if (head == null || node.getPriority() < head.getPriority()) {
            node.setNext(head);
            head = node;
        } else {
            Node current = head;

            while (current.getNext() != null && current.getNext().getPriority() <= node.getPriority()) {
                current = current.getNext();
            }

            node.setNext(current.getNext());
            current.setNext(node);
        }

        size++;
        System.out.print("enqueued: "); printQueue();
        System.out.println();
        System.out.println("size: " + size());
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }

        Node dequeueNode = head;
        head = head.getNext();
        dequeueNode.setNext(null);
        size--;

        System.out.print("dequeued: "); printQueue();
        System.out.println();
        System.out.println("size: " + size());

        return dequeueNode.getData();
    }

    public int size() {
        return size;
    }
    
    public void printQueue() {
        Node current = head;
        
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

////////////////////////////////////////

public class PQ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String order = scan.nextLine().trim();
        String dequeueMode = scan.nextLine().trim();
        String charSet = scan.nextLine().trim();

        String[] charSplit = charSet.split(" ");

        AlphabetLinkedPQ pq = new AlphabetLinkedPQ(order);

        for(String chr : charSplit){
            pq.enqueue(chr);
        } 
        
        if (dequeueMode.equals("on")){
            System.out.println("Dequeue mode: ON");

            while(pq.size() > 0){
                pq.dequeue();
            } 
        }
        else if (dequeueMode.equals("off")) {
            System.out.println("Dequeue mode: OFF");
        }
        scan.close();
    }
}