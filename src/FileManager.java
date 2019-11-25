import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public void writeDataToFile(int[] arr, String filename) {
        try (FileWriter writer = new FileWriter(filename);
             BufferedWriter bw = new BufferedWriter(writer)) {
            for(int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void writeDatatocsv(String [] arr, String filename) throws Exception{
        FileWriter fw = new FileWriter(filename,true);
        for(int i=0;i<arr.length;i++){
            fw.write(arr[i] + " ");
        }
        fw.write("\n");
        fw.close();
    }
}
