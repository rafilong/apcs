import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Dijkstras {
    /** The graph where the shortest paths are to be found */
    private Graph graph;

    /** The nodes that are currently not selected as the minimum */
    private ArrayList<DijNode> unselected;

    /** Nodes already selected as the minimum and search */
    private ArrayList<DijNode> selected = new ArrayList<DijNode>();

    /**
     * A constructor for Dijkstra that uses a graph as input
     * Node names are randomly assigned using UUIDs - find the names by calling printGraph in Graph
     * This constructor also calls methods to calculate the shortest paths
     *
     * @param graph the graph of nodes and edges to calculate on
     */
    public Dijkstras(Graph graph) {
        this.graph = graph;
        setStart();
        this.calculate();
    }

    /**
     * A constructor for Dijkstra that uses a matrix as input, and converts it to a graph
     * Node names are randomly assigned using UUIDs - find the names by calling printGraph in Graph
     * This constructor also calls methods to calculate the shortest paths
     *
     * @param matrix the adjency matrix
     */
    public Dijkstras(int[][] matrix, int start) {
        // creates the nodes and sets the names
        graph = new Graph();
        for (int[] node : matrix) {
            graph.addNode(new DijNode());
        }
        graph.setStart(graph.getNodes()[start]);

        // sets the edges in between the nodes
        matrixSetEdges(matrix);
        // sets up the start node in order to be able to begin calculations
        setStart();
        // begins calcuations
        this.calculate();
    }

    /**
     * A constructor for Dijkstra that uses a matrix as input, and converts it to a graph
     * Node names are randomly assigned using UUIDs - find the names by calling printGraph in Graph
     * This constructor also calls methods to calculate the shortest paths
     *
     * @param matrix the adjency matrix
     */
    public Dijkstras(int[][] matrix, int start, String[] names) {
        // creates the nodes and starts setting names
        graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            graph.addNode(new DijNode(names[i]));
        }
        graph.setStart(graph.getNodes()[start]);

        // sets the edges in between the nodes
        matrixSetEdges(matrix);
        // sets up the start node in order to be able to begin calculations
        setStart();
        // begins calcuations
        this.calculate();
    }

    /**
     * A constructor for Dijkstra that uses a matrix represented as a list as input, and converts it to a graph
     * Node names are randomly assigned using UUIDs - find the names by calling printGraph in Graph
     * This constructor also calls methods to calculate the shortest paths
     *
     * The format of the list is each node is specified with the edges it connects TO, and then repeats until
     * all are finished.
     *
     * @param matrixList the adjency matrix represented in a list
     */
    public Dijkstras(int[] matrixList, int start, String[] names) {
        // finds the number of nodes represented in the matrix
        int numNodes = (int) Math.sqrt(matrixList.length);

        // creates the nodes and starts setting names
        graph = new Graph();
        for (int i = 0; i < numNodes; i++) {
            graph.addNode(new DijNode(names[i]));
        }
        graph.setStart(graph.getNodes()[start]);

        // for the nodes and edges
        for (int n = 0; n < numNodes; n++) {
            for (int e = 0; e < numNodes; e++) {
                // if the weight isn't -1, which means there is no connection
                // multiplies the node it is currently by the number of nodes and then adds the edge to find the
                //  correct information
                if (matrixList[n * numNodes + e] != -1) {
                    // adds an edge between the nodes in question
                    graph.getNodes()[n].addEdge(graph.getNodes()[e], matrixList[n * numNodes + e]);
                }
            }
        }

        // sets up the start node in order to be able to begin calculations
        setStart();
        // begins calcuations
        this.calculate();
    }

    /**
     * Sets the edges between the nodes using an adjacency matrix
     * Meant to only be used upon object creation by matrix
     *
     * @param matrix the adjacency matrix to find the nodes in
     */
    private void matrixSetEdges(int[][] matrix) {
        // for the nodes and edges
        for (int n = 0; n < matrix.length; n++) {
            for (int e = 0; e < matrix.length; e++) {
                // if the weight isn't -1, which means there is no connection
                if (matrix[n][e] != -1) {
                    // adds an edge between the nodes in question
                    graph.getNodes()[n].addEdge(graph.getNodes()[e], matrix[n][e]);
                }
            }
        }
    }

    /**
     * Sets the start of the graph to be actually recognized as the start, and to
     * remove and add it from the correct lists (eg unselected and selected)
     */
    private void setStart() {
        // adds all of the nodes to unselected
        unselected = new ArrayList<DijNode>(Arrays.asList((DijNode[]) graph.getNodes()));
        // sets the shortest distance to the start node as 0
        ((DijNode) graph.getStartNode()).setShortDist(0);
        // removes the start node from unselected
        unselected.remove(graph.getStartNode());
        // adds the start node to selected
        selected.add((DijNode) graph.getStartNode());
    }

    /**
     * Removes all of the values generated
     * @param graph
     */
    public void reset(Graph graph) {
        // sets all the short distances to infinity and closet from to null
        for (DijNode node : (DijNode[]) graph.getNodes()) {
            node.setShortDist(Integer.MAX_VALUE);
            node.setClosestFrom(null);
        }

        // clears selected and calls setStart
        selected = new ArrayList<DijNode>();
        setStart();
    }

    /**
     * Calls updateUnselected and selectMin until all the shortest paths are found
     */
    public void calculate() {
        while (unselected.size() > 0) {
            updateUnselected();
            selectMin();
        }
    }

    /**
     * Updates the unselected nodes based on the now-selected nodes
     */
    public void updateUnselected() {
        // for all of the selected nodes edges
        for (DijNode node : selected) {
            for (int e = 0; e < node.getEdges().length; e++) {
                // sets to as a value for storage
                DijNode to = (DijNode) node.getEdges()[e].getTo();
                // if the new distance is shorter than the old one set it as the new distance and shortest node
                if (to.getShortDist() >= node.getShortDist() + node.getEdges()[e].getWeight()) {
                    to.setClosestFrom(node);
                    to.setShortDist(node.getShortDist() + node.getEdges()[e].getWeight());
                }
            }
        }
    }

    /**
     * Finds the minimum value out of the unselected nodes and makes it selected
     */
    public void selectMin() {
        // sets the first node as the smallest one
        DijNode minNode = unselected.get(0);

        // iterates through as checks if there is a smaller one
        for (DijNode node : unselected) {
            if (node.getShortDist() < minNode.getShortDist()) {
                minNode = node;
            }
        }

        // moves the smallest node from unselected to selected
        unselected.remove(minNode);
        selected.add(minNode);
    }

    /**
     * Prints the result of performing Dijkstras algorithm
     */
    public void printResult() {
        System.out.println("The results of Dijkstra in the following format:");
        System.out.println("Node | Closest node on path | Total distance to node");

        // for all of the nodes in the graph
        for (DijNode node : (DijNode[]) graph.getNodes()) {
            // print the name of the node
            System.out.print(node.getName() + " ");
            if (node.getClosestFrom() == null) {
                // if short node is null print a blank space
                System.out.print("-" + " ");
            } else {
                // else print the node
                System.out.print(node.getClosestFrom().getName() + " ");
            }
            // then print the total distance from the start there
            System.out.println(node.getShortDist());
        }
    }
}