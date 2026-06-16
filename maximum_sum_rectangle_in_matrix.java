public class MaxSumRectangle {

    static int kadane(int[] arr) {

        int max = arr[0];
        int current = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            max = Math.max(max, current);
        }

        return max;
    }

    static int maxRectangle(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int result = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {

            int[] temp = new int[rows];

            for (int right = left; right < cols; right++) {

                for (int i = 0; i < rows; i++)
                    temp[i] += mat[i][right];

                result = Math.max(result, kadane(temp));
            }
        }

        return result;
    }
}
