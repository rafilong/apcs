/**
 * Answers to question 2 in ThinkAPJava chapter 15
 * http://www.greenteapress.com/thinkapjava/thinkapjava.pdf
 *
 * @author Rafi Long
 *
 * Edits by Rafi:
 * - created object method version of abs (see abs documentation for changes)
 */
public class Question2 extends Complex {
    /**
     * Original version
     */
    public static double abs(Complex c) {
        return Math.sqrt(c.real * c.real + c.imag * c.imag);
    }

    /**
     * Object method version
     *
     * Edits by Rafi:
     * 1) Removed static keyword
     * 2) Removed Complex parameter
     * 3) replaced c with this
     */
    public double abs() {
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }
}