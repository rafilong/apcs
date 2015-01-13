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
public class PriorityQueue<T extends Comparable> {

    private BST data;

    private int size = 0;

    boolean maxTop = true;

    public static void main(String args[]) {
        PriorityQueue queue = new PriorityQueue();
        Randp rands = new Randp(20);

        for (int i = 0; i < 20; i++) {
            queue.data.getTree().insert(rands.nextInt());
        }

        queue.data.printTree();
        System.out.println(queue.poll());
        queue.data.printTree();
        queue.reverseComparator();
        queue.remove(1);
        System.out.println(queue.poll());
        queue.data.printTree();
        System.out.println(queue.poll());
        queue.data.printTree();
    }

    public PriorityQueue() {
        data = new BST(null);
    }

    public int size() {
        return this.size;
    }

    public boolean add(T datum) {
        data.getTree().insert(datum);
        size++;
        return true;
    }

    public boolean remove(T datum) {
        if (data.getTree().remove(datum)) {
            size--;
            while (data.getTree().remove(datum)) {
                size--;
            }
            return true;
        } else {
            return false;
        }
    }

    public T poll() {
        if (maxTop) {
            BSTnode current = data.getTree();
            while (current.isRightDead()) {
                current = current.getRight();
            }
            T datum = (T) current.getDatum();
            current.remove();
            return (T) current.getDatum();
        } else {
            BSTnode current = data.getTree();
            while (current.isLeftDead()) {
                current = current.getLeft();
            }
            T datum = (T) current.getDatum();
            current.remove();
            return datum;
        }
    }

    public void clear() {
        data = new BST(null);
    }

    public void reverseComparator() {
        maxTop = !maxTop;
    }

    public boolean contains(T datum) {
        return data.getTree().contains(datum);
    }

    public T peek() {
        if (maxTop) {
            BSTnode current = data.getTree();
            while (current.isRightDead()) {
                current = current.getRight();
            }
            return (T) current.getDatum();
        } else {
            BSTnode current = data.getTree();
            while (current.isLeftDead()) {
                current = current.getLeft();
            }
            return (T) current.getDatum();
        }
    }
}