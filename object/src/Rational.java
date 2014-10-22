/**
 * Answers to question 4 in ThinkAPJava chapter 15
 * http://www.greenteapress.com/thinkapjava/thinkapjava.pdf
 *
 * Question 4.1:
 * Transform the methods in the Rational class from class methods to
 * object methods, and make the necessary changes in main.
 *
 *
 *
 *
 * Question 4.2:
 * Make a few mistakes. Try invoking class methods as if they were object
 * methods and vice-versa. Try to get a sense for what is legal and what
 * is not, and for the error messages that you get when you mess up.
 *
 * Experimented with this a bit, and can conclude that when invoking an object method
 * from static content can not be done unless invoking with a variable. I learned that
 * you can in fact invoke object methods without using a variable, as it passes this
 * as default. This makes sense, as this is used whenever a local variable appears
 * higher in the scope.
 *
 *
 * Question 4.3:
 * Think about the pros and cons of class and object methods. Which
 * is more concise (usually)? Which is a more natural way to express
 * computation (or, maybe more fairly, what kind of computations can be
 * expressed most naturally using each style)?
 *
 * @author Rafi Long
 *
 * Edits by Rafi:
 * - got functions from https://github.com/42mileslong/intro-java/blob/master/Chapter%2011%20Exercises/src/Rational.java
 * - made everything object-oriented
 */
public class Rational {
    int numerator, denominator;

    /**
     * A constructor that takes no arguments
     */
    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * Constructor with arguments
     * @param d the denominator value
     * @param n the numerator value
     */
    public Rational(int n, int d) {
        this.numerator = n;
        this.denominator = d;
    }

    /**
     * prints a Rational object
     */
    public void printRational() {
        System.out.println(this.numerator +  "/"  + this.denominator);
    }

    /**
     * Reverses the sign of a rational number
     * Edits the values, so there is no return value
     */
    public void negate() {
        this.numerator = this.numerator * -1;
        if(this.denominator <= 0) {
            this.numerator = this.numerator * -1;
            this.denominator = this.denominator * -1;
        }
    }

    /**
     * Reverses the numerator and the denominator
     * Edits the values, so there is no return value
     */
    public void invert() {
        int tempN = this.numerator;
        int tempD = this.denominator;

        this.numerator = tempD;
        this.denominator = tempN;
    }

    /**
     * Converts the rational number to a double
     * @return the double
     */
    public double toDouble() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    /**
     * Reduces a rational number to its lowest terms
     * Prints the number
     *
     * Note: this function does not change the values or return a function. It only prints the solution.
     */
    public void reduce() {
        int remain, num1, num2;
        num1 = this.numerator;
        num2 = this.denominator;
        remain = num1 % num2;
        while(remain != 0) {
            remain = num1 % num2 ;
            num1 = num2;
            num2 = remain;
        }
        int GCD = num1;

        Rational ret = new Rational(this.numerator/GCD, this.denominator/GCD);

        // invokes printRational (the scope is the object that the function is called on)
        ret.printRational();
    }

    /**
     * Takes 2 rational numbers as arguments and returns a new rational number that is the added values
     * @param that the number `this` is being added to
     * @return the combined values of `this` and `that`
     */
    public Rational add(Rational that) {
        Rational retAdd = new Rational(0, 0);
        if(this.denominator == that.denominator) {
            retAdd.numerator = this.numerator + that.numerator;
            retAdd.denominator = this.denominator;
            return retAdd;
        } else {
            retAdd.numerator = this.numerator * that.denominator;
            retAdd.denominator = this.denominator * that.denominator;

            that.numerator = that.numerator * this.denominator;
            that.denominator = that.denominator * this.denominator;

            retAdd.numerator += that.numerator;

            int remain, num1, num2;
            num1 = retAdd.numerator;
            num2 = retAdd.denominator;
            remain = num1 % num2;
            while(remain != 0) {
                remain = num1 % num2 ;
                num1 = num2;
                num2 = remain;
            }
            int GCD = num1;

            retAdd.numerator = retAdd.numerator/GCD;
            retAdd.denominator = retAdd.denominator/GCD;

            return retAdd;
        }
    }
}
