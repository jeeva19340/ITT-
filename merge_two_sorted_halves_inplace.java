import java.util.Arrays;

public class MergeSortedHalves {

    static void merge(int arr[], int mid) {

        int i = 0;
        int j = mid;

        while (i < j && j < arr.length) {

            if (arr[i] <= arr[j]) {
                i++;
            } else {

                int temp = arr[j];

                for (int k = j; k > i; k--)
                    arr[k] = arr[k - 1];

                arr[i] = temp;

                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 8, -1, 7, 10};

        merge(arr, 3);

        System.out.println(Arrays.toString(arr));
    }
}
