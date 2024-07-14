# Earthquake Notification System

Our program will receive input from two input files:

- The first file (input.txt) provides information on the location, time, and magnitude, and depth of the earthquakes in or around Turkey.
- The second file (request.txt) contains user requests.

In each line, the earthquake is defined as follows:

- [LOCATION] [DATE given as DD.MM.YYYY] [TIME given as HH:MM:SS] [Magnitude: DoubleValue] [Depth: DoubleValue km]

To store the information given in this file (input.txt), we’ll implement a doubly linked list where each node has the location, date, time, magnitude, and depth of an earthquake. The doubly linked list will have one node for each earthquake given in a separate line

The second input file (request.txt) will be a series of requests by the users of the notification system. The users may request adding/removing an earthquake, or query for earthquakes. Each query can only have a single attribute and a condition. For the add and delete requests there should be all the information about an earthquake. I'll put sample request.txt file.

- For magnitude and depth attributes, there can only be ( > , <, = ) operators.
- For location and date attributes, there can only be ( = ) operator.
- We won't write cases for time attributes.
- We'll print the “-” sign after each query.

There will be an output file (output.txt) that will be a series of responses to the queries. A sample content of output.txt is given.