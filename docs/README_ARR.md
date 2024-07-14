# Array ADT Exercise

## Inspect the MyArray class

- You have an integer array which is not initialized yet. This class will be a dynamic type of an integer array which you will create.

## Implement the functions of MyArray class

- The MyArray class is your Dynamic Array data structure which you are going to implement.
- arr is a reference to MyArray object's dynamic array.
- The constructor creates an empty array with the size of 2 at the beginning.
- The addLast method adds the integer number to the end of the array if the array has more spaces and if not it doubles the size of the array. The function needs to return the content of the array in the format of display function.
- The addPosition method adds the integer number to the given position of the array if the array has more spaces and if not it doubles the size of the array. If an inaccurate position is selected then function needs to return "error\n". The function needs to return the content of the array in the format of display function.
- The removeLast method removes the integer number to at the end of the array. If the array element number has decreased to quarter of the total size of the array, you need to divide the total size of the array by 2. "error\n" needs to be returned in any improper case. Otherwise, the function needs to return the content of the array in the format of display function.
- The removePosition method removes the integer number to from the given position of the array. If the array element number has decreased to quarter of the total size of the array, you need to divide the total size of the array by 2. "error\n" needs to be returned in any improper case. Otherwise, the function needs to return the content of the array in the format of display function.
- The display method returns the value of the array by putting spaces between each item and at the end, it needs to show the item number and maximum size of the array with the given format.

If we compile the following lines:

MyArray m = new MyArray(); \
System.out.print(m.display()); \
System.out.print(m.addLast(1)); \
System.out.print(m.addLast(2)); \
System.out.print(m.addLast(3)); 

Output needs to be: \
(0/2) \
1 (1/2) \
1 2 (2/2) \
1 2 3 (3/4) \