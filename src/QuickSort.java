public class QuickSort implements SortingAlgorithm{

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            // If current element is smaller than the pivot, swap
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int p = partition(arr, low, high);

            //Recursively sort elements before and after partition
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }

    public void sort(int arr[]){
        sort(arr, 0, arr.length-1);
    }


    public static void main(String[] args){
        QuickSort quickSort = new QuickSort();
        int[] a = {100, 32, 20, 90, 1000};

        System.out.println("Before: ");
        for(int i : a){
            System.out.println(i);
        }

        quickSort.sort(a);

        System.out.println("After: ");
        for(int i : a){
            System.out.println(i);
        }
    }

}
