import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The type File manager.
 */
public class FileManager {
    /**
     * Write data to file.
     *
     * @param arr      the arr
     * @param filename the filename
     */
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

    /**
     * Write datatocsv.
     *
     * @param arr      the arr
     * @param filename the filename
     * @throws Exception the exception
     */
    public void writeDatatocsv(String [] arr, String filename) throws Exception{
        FileWriter fw = new FileWriter(filename,true);
        for(int i=0;i<arr.length;i++){
            fw.write(arr[i] + " ");
        }
        fw.write("\n");
        fw.close();
    }
}
