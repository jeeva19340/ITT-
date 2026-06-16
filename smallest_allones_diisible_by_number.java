import java.math.BigInteger;

public class OnesDivisible {

    public static void main(String[] args) {

        int n = 13;

        String num = "1";

        while (true) {
            BigInteger value = new BigInteger(num);

            if (value.mod(BigInteger.valueOf(n))
                    .equals(BigInteger.ZERO)) {
                System.out.println(num);
                break;
            }

            num += "1";
        }
    }
}
