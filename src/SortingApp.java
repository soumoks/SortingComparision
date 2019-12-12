import java.util.Random;

/**
 * The type Sorting app.
 */
public class SortingApp {
    private Algorithm algorithmClass = new Algorithm();
    private FileManager fileManager = new FileManager();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String [] args) throws Exception {
        String order = "";
        int size = 0;
        String algorithm = "";
        String outputFile = "";
        int [] inputArray;
        SortingApp app = new SortingApp();

        if(args.length > 0 && args.length == 4 && app.validateOrder(args[0]) && app.validateAlgorithm(args[2]) && app.validateSize(args[1])){
            order = args[0];
            size = Integer.parseInt(args[1]);
            algorithm = args[2];
            outputFile = args[3];
            System.out.println("Selected parameters:");
            System.out.println("Argument lenght: " + args.length);
            System.out.println("Order: " + order);
            System.out.println("Size: " + size);
            System.out.println("Algorithm: " + algorithm);
            System.out.println("OutputFile: " + outputFile);
            System.out.println();
            inputArray = app.generateArray(order,size);
            System.out.println("Input array generated is :");
            app.printArray(inputArray);
            System.out.println();
            System.out.println("Running sort...");
            app.runSort(inputArray, algorithm,outputFile);
            System.out.println();
            System.out.println();
            System.out.println("Sorted array is:");
            app.printArray(inputArray);
            System.out.println();
            System.out.println("Running Test case with multiple inputs...");
            app.dataCollectionTestCase();
            System.out.println("Test case complete");
        }
        else{
            System.out.println("Please correct your inputs and try again");
        }
    }


    private boolean validateOrder(String myOrder){
        //Possible values for order
        String [] orderValues = {"ascending","descending","random"};
        boolean validOrder = false;
        for(String temp:orderValues){
            if(temp.equals(myOrder.toLowerCase())){
                validOrder = true;
                break;
            }
            else{
                validOrder = false;
            }
        }
        return validOrder;
    }

    private boolean validateAlgorithm(String myAlgorithm){
        //Possible values for algorithm.
        String [] algorithmValues = {"bubble","insertion","merge","quick"};
        boolean validAlgorithm = false;
        for(String temp:algorithmValues){
            if(temp.equals(myAlgorithm.toLowerCase())){
                validAlgorithm = true;
                break;
            }
            else{
                validAlgorithm = false;
            }
        }
        return validAlgorithm;
    }

    private boolean validateSize(String size) {
        return Integer.parseInt(size) > 0;
    }

    private int [] generateArray(String myOrder, int mySize){
        int [] myArray = new int[mySize];

        if(myOrder.toLowerCase().equals("ascending")){
            for(int i=0;i<mySize;i++){
                myArray[i] = i+1;
            }
        }
        else if(myOrder.toLowerCase().equals("descending")){
            for(int i=0;i<mySize;i++){
                myArray[i] = mySize-i;
            }
        }
        else  if(myOrder.toLowerCase().equals("random")){
            for(int i=0;i<mySize;i++){
                myArray[i] = getRandomNumberInts(1,mySize);
            }
        }
        return myArray;
    }

    /**
     * Print array.
     *
     * @param myArray the my array
     */
    public void printArray(int [] myArray){
        for(int i=0;i<myArray.length;i++){
            System.out.print(myArray[i] + " ");
        }
    }

    private int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }

    private long runSort(int[] inputArray, String algorithm,String outputFile) {
        SortingApp app = new SortingApp();
        long startTime,endTime = 0;
        long duration = 0;
        if(algorithm.equalsIgnoreCase("bubble")) {
            startTime = System.nanoTime();
            algorithmClass.bubbleSort(inputArray);
            endTime = System.nanoTime();
            duration = calculateDuration(startTime,endTime);
            System.out.println("Time required for bubble sort for input array size: " + inputArray.length + " is: " + duration);
            //algorithmClass.printList(inputArray);
            fileManager.writeDataToFile(inputArray, outputFile);
        }
        else if(algorithm.equalsIgnoreCase("insertion")){
            startTime = System.nanoTime();
            algorithmClass.insertionSort(inputArray);
            endTime = System.nanoTime();
            duration = calculateDuration(startTime,endTime);
            System.out.println("Time required for Insertion sort for input array size: " + inputArray.length + " is: " + duration);
            //algorithmClass.printList(inputArray);
            fileManager.writeDataToFile(inputArray, outputFile);
        }
        else if(algorithm.equalsIgnoreCase("merge")){
            startTime = System.nanoTime();
            algorithmClass.mergeSort(inputArray,0,inputArray.length -1);
            endTime = System.nanoTime();
            duration = calculateDuration(startTime,endTime);
            System.out.println("Time required for Merge sort for input array size: " + inputArray.length + " is: " + duration);
            //algorithmClass.printList(inputArray);
            fileManager.writeDataToFile(inputArray,outputFile);
        }
        else if(algorithm.equalsIgnoreCase("quick")) {
            startTime = System.nanoTime();
            algorithmClass.quickSort(inputArray, 0, inputArray.length - 1);
            endTime = System.nanoTime();
            duration = calculateDuration(startTime,endTime);
            System.out.println("Time required for Quick sort for input array size: " + inputArray.length + " is: " + duration);
            //algorithmClass.printList(inputArray);
            fileManager.writeDataToFile(inputArray, outputFile);
        }
        return duration;
    }

    /**
     * Calculate duration long.
     *
     * @param startTime the start time
     * @param endTime   the end time
     * @return the long
     */
    public long calculateDuration(long startTime, long endTime){
        return endTime - startTime;
    }

    /**
     * Test case to generate a table as follows.
     * size,order,algorithm,time with the possible values mentioned below.
     *
     * @throws Exception the exception
     */
    public void dataCollectionTestCase() throws Exception {
        String [] algorithmValues = {"bubble","insertion","merge","quick"};
        String [] orderValues = {"ascending","descending","random"};

        /*
        Commented the below sizeValues with all the different elements to save time on each run.
        Please uncomment to test with all input sizes.
         */
        //int [] sizeValues = {10,100,1000,10000,100000,1000000};
        int [] sizeValues = {10,100,1000,10000};
        int [] inputArray;
        long duration = 0;

        //writeData will be of the format size,order,algorithm,time for each use-case
        String [] writeData = new String[4];
        FileManager filemgr = new FileManager();

        for (String myAlgorithm : algorithmValues) {
            for (String myOrder : orderValues) {
                for (int mySize : sizeValues) {
                    String mySizeToString = mySize + "";
                    writeData[0] = mySizeToString;
                    writeData[1] = myOrder;
                    writeData[2] = myAlgorithm;
                    inputArray = generateArray(myOrder, mySize);
                    duration = runSort(inputArray, myAlgorithm, "dummy");
                    String durationToString = duration + "";
                    writeData[3] = durationToString;
                    filemgr.writeDatatocsv(writeData, "data.csv");
                }
            }
        }
    }
}

