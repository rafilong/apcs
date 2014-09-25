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
 * My declaration mechanism would allow users to declare variables that are global across all classes and methods. In
 * order to use them you would have to use a global keyword in declaration, as you would static. In order to avoid
 * conflicts with local variables, you would use the namespace global.* in order to differentiate them from variables
 * that appear higher on the stack.
 *
 * This declaration mechanism would be nice to use for variables that need to be accessed globally and don't fit under
 * any specific class. However, a system like this isn't really needed, as variables can be accessed globally by
 * using the public prefix and accessing it using the class namespace. Most variables are more related to one class than
 * another, so using them as public class variables works a lot better than global variables. Global variables wouldn't
 * be as good as public class variables as you would have to have longer variable names. This is because the class
 * namespace already gives the user some basic information on what the variable is used for. A global variable that
 * denoted a frame width would probably be called using global.frameWidth, while in the frame class it would be
 * Frame.width.
 * 
 * Question 5:
 * Is it a good idea to be able to change the scope of a variable based on a conditional value that is not known
 * until runtime?
 *
 * This is not a good idea. The scope of a variable is completely necessary to know before running the program in order
 * to avoid logic errors. By changing the scope only after it is compiled on a conditional value would make it very hard
 * to keep track of the scope of the variables in a program. By having scope follow predestined rules, programmers who
 * know their scopes confidently know that their program will access the right variables in the right place, and will
 * run without scope-related logic errors.
 */
