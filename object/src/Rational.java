/**
 * Answers to question 3 in ThinkAPJava chapter 15
 * http://www.greenteapress.com/thinkapjava/thinkapjava.pdf
 *
 * Question 3.1:
 * Transform the methods in the Rational class from class methods to
 * object methods, and make the necessary changes in main.
 *
 *
 *
 *
 * Question 3.2:
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
 * Question 3.3:
 * Think about the pros and cons of class and object methods. Which
 * is more concise (usually)? Which is a more natural way to express
 * computation (or, maybe more fairly, what kind of computations can be
 * expressed most naturally using each style)?
 *
 * @author Rafi Long
 *
 * Edits by Rafi:
 * -
 */
public class Rational {
}
