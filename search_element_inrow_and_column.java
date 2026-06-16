public class SearchMatrix {

    static boolean search(int[][] mat, int x) {

        int row = 0;
        int col = mat[0].length - 1;

        while (row < mat.length && col >= 0) {

            if (mat[row][col] == x)
                return true;

            if (mat[row][col] > x)
                col--;
            else
                row++;
        }

        return false;
    }
}
