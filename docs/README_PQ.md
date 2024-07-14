# Priority Queue Exercise

In here, we are going to implement a program that sorts the given char set both alphabetically and reverse-alphabetically using Priority Queues.

PQ will take English alphabet characters (lower case) as input. The priority of each character is its order in the alphabet.

We will also implement the PQ in the reverse order of the alphabet depending on the order mode. Eg:
- Normal: a->0, c->2, z->25.
- Reverse: a->25, c->23, z->0.

We will implement the PQ using linked lists: a-> j -> l -> q
- Enqueue "b":
- current = a
- a.next = b
- b.next = current.next
- a -> new node -> j -> l -> q
- a -> b -> j -> l -> q

## Complete Node.java

Each node must have a String type variable to store its data, an integer variable as its priority and a next node.

The constructor must take and initialize necessary parameters.

## Complete AlphabetLinkedPQ.java

PQ must have a head, an integer variable of size and a String that determines the order.

The constructor must take and initialize necessary parameters.

We use “str.charAt(0) - 'a'” to get the alphabetical order of the input character.

## Complete Main.java

The program must take 3 lines of input.

- First line determines if the PQ will be created in aphabetical or in reverse aphabetical order. It can be either “normal” or “reverse”

- Second line can be either “on” or “off”. If it is “on”, it means that dequeue mode is on. Your program must perform dequeue until the PQ is empty. After the last dequeue operation, your program must print the empty PQ, which is an empty line.

- Third line is the input character set.

At each enqueue operation, your program must print the priority of the element that will enqueued, the priority of it, the PQ and the size of the PQ.

At each dequeue operation, your program must print the element that will dequeued, the PQ and the size of the PQ.

## Test Cases

### Test Case 1

Input:
- normal
- on
- x q a j k

Output: 

Enqueue: x \
Priority: 23 \
x \
Size: 1 \
Enqueue: q \
Priority: 16 \
q x \
Size: 2 \
Enqueue: a \
Priority: 0 \
a q x \
Size: 3 \
Enqueue: j \
Priority: 9 \
a j q x \
Size: 4 \
Enqueue: k \
Priority: 10 \
a j k q x \
Size: 5 \
Dequeue mode: on \
Dequeue: a \
j k q x \
Size: 4 \
Dequeue: j \
k q x \
Size: 3 \
Dequeue: k \
q x \
Size: 2 \
Dequeue: q \
x \
Size: 1 \
Dequeue: x \
Size: 0 

### Test Case 2

Input:
- reverse
- off
- u k a o b z e

Output:

Enqueue: u \
Priority: 5 \
u \
Size: 1 \
Enqueue: k \
Priority: 15 \
u k \
Size: 2 \
Enqueue: a \
Priority: 25 \
u k a \
Size: 3 \
Enqueue: o \
Priority: 11 \
u o k a \
Size: 4 \
Enqueue: b \
Priority: 24 \
u o k b a \
Size: 5 \
Enqueue: z \
Priority: 0 \
z u o k b a \
Size: 6 \
Enqueue: e \
Priority: 21 \
z u o k e b a \ 
Size: 7 \
Dequeue mode: off \