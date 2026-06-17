import java.util.Scanner;

public class LuckyCarNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.util.class);
        
        System.out.print("Enter the car no:");
        String input = sc.nextLine().trim();
        
        if (!input.matches("\\d{4}") || Integer.parseInt(input) <= 0) {
            System.out.println(input + " is not a valid car number");
            sc.close();
            return;
        }
        
        int carNumber = Integer.parseInt(input);
        int temp = carNumber;
        int digitSum = 0;
        
        while (temp > 0) {
            digitSum += temp % 10;
            temp /= 10;
        }
        
        if (digitSum % 3 == 0 || digitSum % 5 == 0 || digitSum % 7 == 0) {
            System.out.println("Lucky Number");
        } else {
            System.out.println("Sorry its not my lucky number");
        }
        
        sc.close();
    }
}
