# Word Counter

## Inspect WordCounter.java

In here we are going to count the occurences of the words for a given input.

## Implement main() and displayWordCount() methods

We are going to take an input from the user and counts the words in the given input by ignoring the case sensivity and punctuations. We have a list of stopwords in the main method and you should count them in the Map named stopWordCountMap and for the other words you are going to count the words in to the wordCountMap.

We need to write displayWordCount function to display the contents of a HashMap in the following format "word: occurence"

## Test

Sample Input/Output:
- Input: Hello world! This is a sample input. Hello again this world!
- Output: input: 1 world: 2 again: 1 hello: 2 sample: 1
- Stop Word Count: a: 1 this: 2 is: 1