/**
 * Priority Queue Project
 * Coded by Rafi Long
 *
 * Methods with arrows have to be better than O(log n) time
 *
 * Required methods (required time signature) (my best case time signature):
 * priorityQueue()
 * size() <-- O(1) O(1)
 * add(E c) <-- O(log n) O(log n)
 * remove(Object o) <-- O(n) O(log n)
 * poll() <-- O(log n) O(log n)
 * clear() <-- O(n) O(1)
 * reverseComparator() <-- O(n) O(1)
 *   changes the state of some instance variable
 * contains(Object o) <-- O(n) O(log n)
 * peek() <-- O(log n) O(log n)
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
    /** All of the data of the queue */
    private BST data;

    /** The size of the queue, which is incremented when the size is changed. This keeps time complexities at O(1) */
    private int size = 0;

    /** Whether the maximum value is considered the top or the bottom of the queue */
    boolean maxTop = true;

    public static void main(String args[]) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Randp rands = new Randp(20);

        for (int i = 0; i < 20; i++) {
            queue.data.getTree().insert(rands.nextInt());
        }

        System.out.println("The orignal tree, created by randomly inserting the numbers 1 through 20");
        queue.data.printTree();
        System.out.println();

        System.out.println("Poll with max top set as true is called and the result is: " + queue.poll());
        queue.data.printTree();
        System.out.println();

        queue.remove(4);
        System.out.println("The value of 4 is removed");
        queue.data.printTree();
        System.out.println();

        queue.add(23);
        System.out.println("The value of 23 is added");
        queue.data.printTree();
        System.out.println();

        queue.reverseComparator();
        System.out.println("The comparator is reversed");
        System.out.println();

        System.out.println("Peek is called and the result is: " + queue.peek());
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
            while (!current.isRightDead()) {
                current = current.getRight();
            }
            T datum = (T) current.getDatum();
            current.remove();
            return datum;
        } else {
            BSTnode current = data.getTree();
            while (!current.isLeftDead()) {
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