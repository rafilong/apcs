Dijkstras
Coded by Rafi Long

===

Basic information:

Documentation is in the source headers.

===

How Dijkstras works:

Dijkstra works by starting with the starting node. You know that the shortest path from this node to all of the other nodes will be the shortest path to itself, so it is finished. Now you can update with it's children. You know that the shortest of these paths will be the shortest path possible, so it is now able to be selected. You can now look at it's children for whether they are the shortest or not, and until all of the nodes are selected.

This works because the shortest path through only selected nodes will always be the shortest path as long as all of the selected nodes are picked with this rule. This is because other nodes have to be longer, and so impossible to get to the current node in a shorter distance.

===

How my program works:

My program can be used in lots of different scenarios, and is in this way very encapsulated. Graph, Node, and Edge are applicable in pretty much any situation in which you might need a graph, node, or edge. DijNode extends Node, which allows it to be used in Graph using polymorphism. When creating a Dijkstras object you know the object will be a DijNode, and so you can have the proporties you need through this node. The information on shortest paths are stored in DijNode, not Dijkstras. Dijkstras manipulates this information and updates it to find the shortest path.

===

Problems I came across:

I had a lot of problems with my code the first time I tested in. On using an adjacency matrix to create the Dijkstras object I set it up so -1 would be recognized as no edge, but when I created I created the object I entered 0. This made my program think all nodes were connected to each other through edges with weight 0, making every node reachable in the same length.

My other problem was that I didn't set the start node to have the total distance to the start as 0, so it was infinity, which completely messed up everything.

Other than these 2 issues, I had a bunch of null pointer and not object convertable issues that weren't very hard to fix.