public class Algorithm {

    public int[] bubbleSort(int [] arr) {
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
        return arr;
    }

    public int[] insertionSort(int [] arr){
        for(int i=1,j;i<arr.length;i++){
            int temp = arr[i];
            for(j=i;j>0 && temp < arr[j-1];j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
        return arr;
        //TODO check if array needs to be returned
    }


    public void printList(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
