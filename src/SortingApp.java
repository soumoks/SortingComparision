import java.util.Random;

public class SortingApp {
    public static void main(String [] args){
        String order = "";
        int size = 0;
        String algorithm = "";

        //Contains the name of the outputfile
        String outputFile = "";

        if(args.length > 0 && args.length == 4 && validateOrder(args[0]) && validateAlgorithm(args[2])){
            order = args[0];
            size = Integer.parseInt(args[1]);
            algorithm = args[2];
            outputFile = args[3];
            System.out.println("Argument lenght: " + args.length);
            System.out.println("Order: " + order);
            System.out.println("Size: " + size);
            System.out.println("Algorithm: " + algorithm);
            System.out.println("OutputFile: " + outputFile);
        }
        else{
            System.out.println("Please correct your inputs and try again");
        }

        printArray(generateArray("random",100));
    }

    public static boolean validateOrder(String myOrder){
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

    public static boolean validateAlgorithm(String myAlgorithm){
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

    public static int [] generateArray(String myOrder,int mySize){
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

    public static void printArray(int [] myArray){
        for(int i=0;i<myArray.length;i++){
            System.out.print(myArray[i] + " ");
        }
    }

    public static int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }


}
