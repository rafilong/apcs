import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class MathSet<T> extends TreeSet<T> implements Set<T> {

    public MathSet<T> union(MathSet<T> that) {
        MathSet<T> retval = new MathSet<>();
        retval.addAll(this);
        retval.addAll(that);
        return retval;
    }

    public MathSet<T> intersection(MathSet<T> that) {
        MathSet<T> retval = new MathSet<>();

        for (int i = 0; i < this.size(); i++) {
            if (that.contains(this.first())) {
                retval.add(this.first());
            }
            that.remove(this.first());
            this.remove(this.first());
        }

        return retval;
    }
}
