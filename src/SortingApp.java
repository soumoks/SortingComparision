import java.io.File;
import java.util.Random;

public class SortingApp {
    Algorithm algorithmClass = new Algorithm();
    FileManager fileManager = new FileManager();

    public static void main(String [] args){
        String order = "";
        int size = 0;
        String algorithm = "";
        String outputFile = "";
        int [] inputArray;
        SortingApp app = new SortingApp();

        if(args.length > 0 && args.length == 4 && app.validateOrder(args[0]) && app.validateAlgorithm(args[2])){
            order = args[0];
            size = Integer.parseInt(args[1]);
            algorithm = args[2];
            outputFile = args[3];
            System.out.println("Argument lenght: " + args.length);
            System.out.println("Order: " + order);
            System.out.println("Size: " + size);
            System.out.println("Algorithm: " + algorithm);
            System.out.println("OutputFile: " + outputFile);

            inputArray = app.generateArray(order,size);
            app.runSort(inputArray, algorithm, outputFile);
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

    public void printArray(int [] myArray){
        for(int i=0;i<myArray.length;i++){
            System.out.print(myArray[i] + " ");
        }
    }

    private int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }

    private void runSort(int[] inputArray, String algorithm, String outputFile) {
        SortingApp app = new SortingApp();
        if(algorithm.equalsIgnoreCase("bubble")) {
            algorithmClass.bubbleSort(inputArray);
            algorithmClass.printList(inputArray);
            fileManager.writeDataToFile(inputArray, "Sort.txt");
        }
        else if(algorithm.equalsIgnoreCase("insertion")){
            algorithmClass.insertionSort(inputArray);
            algorithmClass.printList(inputArray);
            fileManager.writeDataToFile(inputArray, "Sort.txt");
        }
        else if(algorithm.equalsIgnoreCase("merge")){
            algorithmClass.mergeSort(inputArray,0,inputArray.length -1);
            algorithmClass.printList(inputArray);
            fileManager.writeDataToFile(inputArray,"Sort.txt");
        }
    }
}
