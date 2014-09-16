/*
 * MyScope homework
 * 9/16/14
 * Answers answered by Rafi Long
 * Code provided by Mr. Kuszmaul
 *
 * Code referenced by questions is below the question.
 * Questions and answers are in the comments.
 *
 *
 * Question 1:
 * What does the following code print out?
 *
 * 3
 * 3.14
 * 3
 * 7
 * 7
 * 88
 * 2
 * 2.7
 *
 * Question 2:
 * The number 7 gets printed out twice in a row, but the number 88 is followed by a 2. Why?
 *
 * Because b is a static variable, so changing it's value in one instance changes it in all other instances. Because
 * of this, changing myInstance.b to equal 7 changes MyScope.b and myOtherInstance.b. However, a is an instance
 * variable. By changing myInstance.a to 88, it does _not_ change any other values of a. Because of this,
 * myOtherInstance.a retains it value of 2.
 *
 * Question 3:
 * The first value printed out is that of MyScope.b. If we try to print MyScope.a, what happens, and why?
 *
 * It generates the error "java: non-static variable a cannot be referenced from a static content". This happens
 * because a is a non-static variable, while main is a static method. By using MyScope.a, the program is unsure
 * which instance to reference. MyScope.b works because b is a static variable, and remains constant through all
 * instances.
 */
public class MyScope {
    int a = 2;
    static int b = 3;
    public static void main(String[] args) {
        MyScope myInstance = new MyScope();
        MyScope myOtherInstance = new MyScope();
        double a = 3.14;
        double b = 2.7;
        System.out.println(MyScope.b);
        System.out.println(a);
        System.out.println(myInstance.b);
        myInstance.b = 7;
        System.out.println(myInstance.b);
        System.out.println(myOtherInstance.b);
        myInstance.a = 88;
        System.out.println(myInstance.a);
        System.out.println(myOtherInstance.a);
        System.out.println(b);
    }
}
/*
 * Question 4:
 * Identify a way to generalize the way one can establish the scope of a variable. If you wish, you can invent a new
 * declaration mechanism. Justify and criticize your method.
 *
 * Question 5:
 * Is it a good idea to be able to change the scope of a variable based on a conditional value that is not known
 * until runtime?
 */