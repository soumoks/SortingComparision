public class Algorithm {

    public void bubbleSort(int [] arr) {

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        //TODO check if array needs to be returned
        //return arr;
    }

    public void insertionSort(int [] arr){
        for(int i=1,j;i<arr.length;i++){
            int temp = arr[i];
            for(j=i;j>0 && temp < arr[j-1];j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
        //return arr;
        //TODO check if array needs to be returned
    }

    //Functions for merge sort.
    //https://www.geeksforgeeks.org/merge-sort/
    void merge(int arr[], int l, int m, int r)
    {
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
            } else {
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
    public void mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        //return arr;
    }

    public void quickSort(int [] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi+1, high);
        }
        //return arr;
    }

    /* This function takes last element as pivot, places the pivot element at its correct
       position in sorted array, and places all smaller (smaller than pivot) to left of
       pivot and all greater elements to right of pivot */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // index of smaller element
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public void printList(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
