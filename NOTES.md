---
**NOTE**

1. To calculate the amount to be charged from customer, I used Integer total which added the integer values of each item and then converted to float. Later, printed in the end.

2. HashMap stores values based on their key and not in the order they were added in the HashMap. So, I simply used LinkedHashMap to keep track of the order of insertion of items to the list. 

3. To make sure that fewer tests needed update when a change is made, I used the concepts Single Responsibility Principle (SRP). This helped to divide the functionality of ShoppingCartTest class and make to other classes, one to handle different types of test cases i.e ContentCheck Class and another one to handle features like add an item and print receipt, which were quite repititive,  into ShoppingCartFeatures class.

4. This task was tricky, to get prices first on each line without changing the interface. I thought if the printReceipt() is called twice then prices will appear first else they will apear the normal way. So I used count and counter variables to keep track of the number of times print functions were called. I even made a few changes in ShoppingCartTest.java to test this. For the second call of print function, I removed the printed data, and checked with "price - quantity - item" format type. 

---
