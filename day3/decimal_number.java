import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
  
        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();
        
        if (decimal == 0) {
            System.out.println("Invalid input");
            sc.close();
            return;
        }
        
        String binary = Integer.toBinaryString(decimal);
        int countOfOnes = 0;
        
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                countOfOnes++;
            }
        }
        
        System.out.println("Binary equivalent: " + binary);
        System.out.println("Count of 1's: " + countOfOnes);
        
        sc.close();
    }
}
