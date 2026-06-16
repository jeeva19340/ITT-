public class StringCompression {

    static String compress(String s) {
        StringBuilder result = new StringBuilder();

        int count = 1;

        for (int i = 1; i <= s.length(); i++) {

            if (i < s.length() && s.charAt(i) == s.charAt(i - 1))
                count++;
            else {
                result.append(s.charAt(i - 1));
                if (count > 1)
                    result.append(count);
                count = 1;
            }
        }
        return result.toString();
    }

    static String decompress(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                int count = 0;
                int j = i + 1;

                while (j < s.length() &&
                       Character.isDigit(s.charAt(j))) {
                    count = count * 10 + (s.charAt(j) - '0');
                    j++;
                }

                if (count == 0)
                    count = 1;

                for (int k = 0; k < count; k++)
                    result.append(ch);

                i = j - 1;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "AAACCCBBD";

        String compressed = compress(s);
        System.out.println(compressed);

        System.out.println(decompress(compressed));
    }
}
