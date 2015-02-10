/**
 * Created to test Dijkstras.java
 */
public class Main {

    public static void main(String args[]) {
        Dijkstras test = new Dijkstras(new int[][]{
                {0, 8, 0, 0, 0, 10, 0, 0}, //2  A  2
                {0, 0, 4, 0, 10, 0, 0, 0}, //4  B  2
                {0, 0, 0, 3, 0, 0, 0, 0},  //5  C  1
                {0, 0, 0, 0, 25, 18, 0, 0},//7  D  2
                {0, 0, 0, 9, 0, 0, 7, 0},  //9  E  2
                {5, 7, 3, 0, 2, 0, 0, 0},  //12 F  3
                {0, 0, 0, 2, 0, 0, 0, 3},  //14 G  2
                {4, 9, 0, 0, 0, 0, 0, 0}}  //16 H  2
        );

        test.calculate();
        test.printResult();
    }
}
