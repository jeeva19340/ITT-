import java.util.*;

public class HighestFrequencyChars {
    public static void main(String[] args) {

        String str = "Programming";

        int[] freq = new int[52];

        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z')
                freq[ch - 'A']++;
            else if (ch >= 'a' && ch <= 'z')
                freq[ch - 'a' + 26]++;
        }

        int max = 0;
        for (int x : freq)
            max = Math.max(max, x);

        System.out.print("Highest frequency letters: ");

        for (int i = 0; i < 26; i++)
            if (freq[i] == max)
                System.out.print((char)('A' + i) + " ");

        for (int i = 26; i < 52; i++)
            if (freq[i] == max)
                System.out.print((char)('a' + i - 26) + " ");
    }
}
