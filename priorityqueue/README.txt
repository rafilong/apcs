Priority Queue
Implemented using a binary search tree
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

See the JavaDocs above the methods for specific information for how they work.

===

General overview:

For the priority queue project I had diffculty deciding what data structure to store my data in. My plan was to use an array, and treat it similar to a binary tree, but the difficulty in this was that adding a value would always be O(n), as you had to move all elements past that point backwards. For this reason I decided to use a binary search tree. Because I wrote the binary search tree myself, for a previous project, I was able to reasonably delegate most of my methods, such as add, remove, and contains to the binary search tree. However, I had to write the remove and contains methods for my binary search tree today, which took my around 2 hours because I couldn't figure out how to remove elements with two children. This is a very long story, and I doubt you would be interested, but if you are feel free to contact me and I'd be happy to share it with you, as long as I'm not 40, because I would have probably forgotten the story by then. It might be even longer, because the story was so captivating and exciting, but just contact me if you want to hear it. Below are time complexities of the various methods I implemented.

===

Time Complexities:

size - for this method I just kept a private int that was incremented upwards when elements were added and downwards when elements were removed. This means that finding the size is O(1).

add - for this method I pretty much delegated entirely to the binary search tree, which will have a time complexity of O(log n) if the tree is balanced, and worse if it is not. I felt as though it most general applications it would be balanced, and was therefore satisfied without making a special effort to balance the tree.

remove - this method was a massive pain, but I eventually got it to work after reading online that when a datum is removed, the left branch's rightmost child can replace the datum, and vice versa. Not realizing this sooner, I spent 2 hours trying to get it to work by moving part of the tree up. Not fun

poll - this method either moves down the right or left side of the tree, depending on whether the head of the queue is considered to be the max and min. In a balanced tree this time complexity should be O(log n)

clear - with this method I just overwrote the old tree with a new one. O(1).

reverseComparator - because I don't have to rearrange the data with a reverseComparator and instead just traverse the opposite side of the tree, it is O(1).

contains - in a balanced tree finding a value will be O(log n), and this method is entirely delegated to the method in BST that I wrote today. As with the remove method I could have written it in Priority Queue, but I felt as though it made more sense in BST, and could be very useful if I ever wanted to use my BST again.

peek - see poll. They are exactly the same, except with poll the element found is removed.