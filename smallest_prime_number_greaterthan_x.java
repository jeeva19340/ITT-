public class NextPrime {

    static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int x = 20;

        int num = x + 1;

        while (!isPrime(num))
            num++;

        System.out.println(num);
    }
}
