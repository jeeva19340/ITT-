public class OppositeSigns {

    static boolean hasOppositeSigns(int x, int y) {
        return (x ^ y) < 0;
    }

    public static void main(String[] args) {

        System.out.println(hasOppositeSigns(10, -20));
    }
}
