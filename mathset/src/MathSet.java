import java.util.Set;
import java.util.TreeSet;

/**
 * MathSet
 * Code written by Rafi Long
 *
 * Assignment:
 * Write a class MathSet that implements the Set interface, write union and intersection methods for it.
 *
 * Implementation:
 * Instead of implementing every method in Set, as it is an interface,
 *   I also extended TreeSet, which allowed me to only write the methods
 *   union and intersection. This saved me a lot of work, as I do not have
 *   to write methods that have already been created by someone else.
 */
public class MathSet<T> extends TreeSet<T> implements Set<T> {

    /**
     * A union method.
     * Works by creating a new MathSet, and adding all the elements
     *   from the object that called it and that to the new object.
     *
     * @param that the values to be unioned with
     * @return the unioned set
     */
    public MathSet<T> union(MathSet<T> that) {
        MathSet<T> retval = new MathSet<T>();
        retval.addAll(this);
        retval.addAll(that);
        return retval;
    }

    /**
     * An intersection method.
     * Works by iterating through all the values in the object
     *   that called the element, using contains to check whether
     *   it is in the other set, and if so adding the value
     *   to a new set. The new set is then returned
     *
     * @param that the values to be intersected with
     * @return the intersected set
     */
    public MathSet<T> intersection(MathSet<T> that) {
        MathSet<T> retval = new MathSet<T>();

        while(this.size() > 0) {
            if (that.contains(this.first())) {
                retval.add(this.first());
            }
            that.remove(this.first());
            this.remove(this.first());
        }

        return retval;
    }
}
