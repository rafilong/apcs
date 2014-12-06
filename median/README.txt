Median Finder Homework
Coded by Rafi Long

===

Note:

This program only really works for arrays with an odd number of indices. When there is a even number of indices, it randomly returns either of the two values below and above the median. This is because when I wrote the program I thought of the median as one number, not a number between 2. For this reason, my program fairly oftenly discards one of the two bordering numbers. I spent a couple hours trying to fix this problem, but in the end decided I would have to rewrite the program in order to solve this problem. For this reason, but program works with medians if the definition of a median is changed to the middle number or when there is no middle number one of the two numbers bordering it.

===

Basic information:

Documentation is in the source headers.

This program works by partitioning the array into elements below, above, and the same to a pivot then comparing the sizes of these 3, and the number of elements already removed from both sides, to find the median. This works because the median is the value with the same number of elements greater than and less than on both sides.
