Binary Search Tree
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

See the JavaDocs above the methods for specific information for how they work.

===

Questions (these questions start with number 4):

4. Create a binary search tree by inserting the numbers 1 ... 10000 in random order. 
* Try to predict the average depth of such a tree
     I think the average depth of the tree will be between n and log n, where n is the number of elements. This is a very broad range, as it covers a tree where only one side has children, and also a tree where every node has two children unless it is a leaf. In reality, I think it will be somewhere inbetween, because my tree does not make any effort to be a balanced binary search tree.

* Run your program a few times, record the depths of the trees, and
  compare your prediction to the result
     These were my tree depths for 50 trials with a tree size of 10000 elements:
       30 28 28 29 30 26 28 30 28 30 27 28 28 36 29 29 34 30 28 28 32 27 28 30 28 25 28 29 30 30 29 29 28 29 29 27 32 28 29 27 29 29 30 27 28 27 28 28 28 30 
     The average of these numbers is 28.84. Log base 2 of 10000 is 13.288. This means that my tree is 2 times less efficient than it could be, because the best possible depth is around 13 and mine is around 28.


5. Algorithm analysis.
* What is the worst case order of growth for finding a datum in a binary search tree?
     The worst case order of growth for finding a datum in a binary search tree is O(n). This because the time it takes to find the datum is directly proportional to the depth of the tree, so with a depth of n, worst case, you would have to check every element to find the datum.

* What is the best case?
     The best case order of growth for finding datum is O(1), but that is if the root is the datum you are looking for. The worst case scenario with the best case tree would have a time of O(log n), because the best case tree is log n deep. Any better case would be because of luck in the fact that the datum is not at the bottom of the tree.

* What do you think the average case order of growth is?  (In other words, if a tree were created as
in (3), above, in random order, what would you expect the typical order of growth
for searching to be?)
     It depends on your insertion algorithm. If you create a balanced binary search tree, the worst case is O(log n), and the best case is O(1). The average would be somewhere in between, more likely larger because there is a higher chance of the datum being lower on the tree than higher. With my insertion algorithm, which makes no effort to balance the tree, worst case could be O(n). Because the distribution on either side should be fairly even, because the numbers entered are random, the growth order should be much closer to O(log n) than O(n). This can be seen by the fact that the tree depth is around 2 log n, and is nowhere near n.

* What is the order of growth to insert an element in the tree?
     Because my insertion method moves the element to a leaf, comparing the value with one node at each level, the order of growth for insertion is the same as the depth of the tree, which, as said above, is between O(n) and O(log n), but much closer to O(log n).

* What is the order of growth to print the tree?
     When printing the tree each node is accessed once, so the order of growth is O(n), or the number of elements that are in the tree.

* EXTRA CREDIT: What is the order of growth to delete an element?