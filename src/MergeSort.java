import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
    /*
        Pseudo Code:
        a = 5, 1, 7, 9, 2, 3
        1. Create 2 subarrays
        2. Copy 5, 1, 7 into first array, copy 9, 2, 3 into the other (arrays.copyOfRange())
        3. Split both sides into more subarrays until they cannot be split further
        4. Merge items 1 by 1 into larger arrays
     */

    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public void sort(int[] a){
        sort(a, 0, a.length-1);
    }

    public static void main(String[] args){
        MergeSort mergeSort = new MergeSort();
        int[] a = {30, 20, 10, 50};
        System.out.println(Arrays.toString(a));
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
