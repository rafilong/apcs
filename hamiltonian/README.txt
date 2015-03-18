Hamiltonian Path Using TSP
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

===

Implementation:

In my code I created an interface called PathFinder that all path finding classes can extend. This interface includes two abstract methods, one that returns whether or not there is a valid path, and another that returns the path. Both of these functions take a list of points as input. Other path finding algorithms can extend these classes, and in this way polymorphism can be easily achieved. I considered using this to my advantage when creating my Hamiltonian class, as I could have a local variable of type PathFinder that can be changed with a method. However, this could be misleading, as if a path finding algorithm that did not return a Hamiltonian path was used it would mess up the results. For this reason I left the option of polymorphism available for those you wished to use it, but just hardcoded the TSP class in the Hamiltonian class to make things more clear. In this way creating an interface was not necessary, but it helps other people who use my code more easily understand it. For a while I debated removing the PathFinder interface, but then I decided against it on the grounds that it makes the code easier to explain, use, and expand upon.

The MyPoint class is unchanged from the previous assignment.