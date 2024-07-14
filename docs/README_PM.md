# Product Management

A software company hires us to keep their products in a data structure. The company wants to find their cheapest product quickly. In addition, the company wants to reduce the price of a specific product, remove the cheapest product from sale, and add new products. They want us to implement the following operations:

- **ListMin**
- **RemoveMin**
- **Add**
- **DecreasePrice**

Properties of the structure:

- There cannot be more than one product with the same name, but there may be more than one product with the same price.
- In case of the company wants to remove the item with the minimum price and if there is more than one product with the equal minimum price, then each of them must be removed
- All these operations will be specified in a file.
- The program takes the inputs from “process.txt”

Implement a binary heap for this structure. Make sure RemoveMin and Add works in O(log n), where n is the number of elements in the heap. After finding the product from the data structure, DecreasePrice should also work in O(log n). ListMin must work in O(1). Use arrays to implement heaps. After RemoveMin and DecreasePrice operations, make sure to update the heap and preserve the heap structure.

- Outputs should be same as content of output.txt file.