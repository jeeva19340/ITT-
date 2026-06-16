public class FastPower {

    static long count = 0;

    static double power(double x, int n) {

        if (n == 0)
            return 1;

        double temp = power(x, n / 2);

        count++;

        if (n % 2 == 0)
            return temp * temp;

        count++;

        return x * temp * temp;
    }

    public static void main(String[] args) {

        double result = power(2, 10);

        System.out.println("Result = " + result);
        System.out.println("Multiplications = " + count);
    }
}
