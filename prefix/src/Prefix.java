
public class Prefix {

    public static void main(String args[]) {
        System.out.println(findPrefix("hello", "hehaw"));
    }

    public static String findPrefix(String a, String b) {
        int end = Math.min(a.length(), b.length());
        String retval = "";

        for (int i = 0; i < end; i++) {
            if (a.substring(i, i+1).equals(b.substring(i, i+1))) {
                retval += a.substring(i , i+1);
            } else {
                i = end;
            }
        }

        return retval;
    }
}
