class Node {

    private int data;
    public Node next;

    public Node(int dd) {
        data = dd;
        next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

}


class MyStack {

    private Node first;
    private int size;
    public int tempData;

    public MyStack() {
        first = null;
        size = 0;
    }

    public void push(int dd) {
        Node node = new Node(dd);
        node.setNext(first);
        first = node;
        size++;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("No integers in the stack");
        }

        return first.getData();
    }

    public int pop() {
    	if(isEmpty()) {
            System.out.println("No integers in the stack");
            return 0;
        }

        tempData = first.getData();
        first = first.getNext();
        size--;

        return tempData;     
    }

    public boolean isEmpty() {
        if(getSize() == 0) {
            return true;
        }

        return false;
    }

    public int getSize() {
        return size;
    }  
    
    public String evaluate(String command) {
		StringBuilder sb=new StringBuilder("");
        String[] str = command.split("\\s+");

        for(String scan : str) {
            sb.append(classification(scan));
        }

		return sb.toString();
	}

    public String classification(String scan) {
        StringBuilder sb = new StringBuilder("");

        if(scan.matches("\\d+") || scan.matches("^-?\\d+(\\.\\d+)?$")) {
            sb.append(numbers(scan));
        } else if(scan.matches(".*[+-/*].*") || scan.matches(".*\\p{P}.*")) {
            sb.append(operator(scan));
        } else {
            sb.append(command(scan));
        }

        return sb.toString();
    } 

    public String command(String scan) {
        StringBuilder sb = new StringBuilder("");
        int[] temp = new int[size];
        int i = 0;

        if(scan.equals("print")) {
            sb.append("[");

            while(!isEmpty()) {
                temp[i] = pop();
                sb.append(temp[i]);

                if(!isEmpty()) {
                    sb.append(", ");
                }

                i++;
            }           
            sb.append("]\n");
            
            for(int j = (i - 1); j >= 0; j--) {
                push(temp[j]);
            }

        } else if(scan.equals("pop")) {
            sb.append(pop() + "\n");
        } else if(scan.equals("exit")) {
            sb.append("$\n");
        } else {
            sb.append("Invalid operator\n");
        }

        return sb.toString();
    }

    public String numbers(String scan) {
        StringBuilder sb = new StringBuilder("");
        int number;

        if(scan.matches("\\d+")) {
            number = Integer.parseInt(scan);
            push(number);
        } else {
            sb.append("Invalıd operator\n");
        }

        return sb.toString();
    }

    public String operator(String scan) {
        StringBuilder sb = new StringBuilder("");
        int num1, num2;

        if(scan.equals("+")) {
            if(getSize() <= 1) {
                sb.append("Not enough integers in the stack\n");
                return sb.toString();
            }

            num1 = pop();
            num2 = pop();
            push(num1 + num2);
        } else if(scan.equals("-")) {
            if(getSize() <= 1) {
                sb.append("Not enough integers in the stack\n");
                return sb.toString();
            }

            num1 = pop();
            num2 = pop();
            push(num2 - num1);
        } else if(scan.equals("*")) {
            if(getSize() <= 1) {
                sb.append("Not enough integers in the stack\n");
                return sb.toString();
            }
            
            num1 = pop();
            num2 = pop();
            push(num1 * num2);
        } else if(scan.equals("/")) {
            if(getSize() <= 1) {
                sb.append("Not enough integers in the stack\n");
                return sb.toString();
            }

            num1 = pop();
            num2 = pop();
            if(num1 == 0) {
                push(num2);
                push(num1);
                sb.append("error\n");
            } else {
                push(num2 / num1);
            }
        } else if(scan.equals("%")) {
            if(getSize() <= 1) {
                sb.append("Not enough integers in the stack\n");
                return sb.toString();
            }

            num1 = pop();
            num2 = pop();
            push(num2 % num1);
        } else {
            sb.append("Invalid Operator\n");
        }

        return sb.toString();
    }
}


