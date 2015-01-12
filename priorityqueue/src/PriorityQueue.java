import java.util.Vector;

/**
 * Priority Queue Project
 * Coded by Rafi Long
 *
 * Methods with arrows have to be better than O(log n) time
 *
 * Required methods:
 * priorityQueue()
 * size() <-- O(1)
 * add(E c) <-- O(log n)
 * remove(Object o) <-- O(n)
 * poll() <-- O(log n)
 * clear() <-- O(n)
 * reverseComparator() <-- O(n)
 *   changes the state of some instance variable
 * contains(Object o) <-- O(n)
 * peek() <-- O(log n)
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

    boolean maxTop = true;

    public PriorityQueue() {

    }

    public int size() {
        return this.size;
    }

    public boolean add(E c) {
        
    }

    public boolean remove(E c) {
        
    }

    public E poll() {

    }

    public void clear() {

    }

    public void reverseComparator() {
        maxTop = !maxTop;
    }

    public boolean contains(E c) {

    }

    public E peek() {

    }
}
