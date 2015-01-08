import java.util.Vector;

/**
 * Priority Queue Project
 * Coded by Rafi Long
 *
 * Methods with arrows have to be better than O(log n) time
 *
 * Required methods:
 * size()
 * add(E c) <--
 * priorityQueue()
 * remove(Object o) <--
 * poll() <--
 * clear()
 * reverseComparator()
 * contains(Object o) <--
 * peek() <--
 *
 * Extra credit methods:
 * other constructors
 * comparator
 * iterator
 * offer
 * spliterator
 * toArray
 * merge
 */
public class PriorityQueue<E extends Comparable> {

    private Vector datum = new Vector();

    private int size = 0;

    public PriorityQueue() {

    }

    public int size() {
        return this.size;
    }

    public boolean add(E c) {
        
    }
}
