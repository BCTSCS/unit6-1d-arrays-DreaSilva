import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperator {
    private static String staticFilePath;

    public static String getStaticFilePath() {
        return staticFilePath;
    }

    public static void setStaticFilePath(String filePath) {
        staticFilePath = filePath;
    }

    public static String[] toStringArray(int arraySize) {
        return toStringArray(staticFilePath, arraySize);
    }

    public static int[] toIntArray(int arraySize) {
        return toIntArray(staticFilePath, arraySize);
    }

    public static double[] toDoubleArray(int arraySize) {
        return toDoubleArray(staticFilePath, arraySize);
    }
   
    public static String[] toStringArray(String filePath, int arraySize) {
        String[] array = new String[arraySize];
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine() && index < arraySize) {
                array[index] = input.nextLine();
                index++;
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return array;
    }

    public static int[] toIntArray(String filePath, int arraySize) {
        int[] array = new int[arraySize];
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine() && index < arraySize) {
                array[index] = input.nextInt();
                index++;
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return array;
    }

    public static double[] toDoubleArray(String filePath, int arraySize) {
        double[] array = new double[arraySize];
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine() && index < arraySize) {
                array[index] = input.nextDouble();
                index++;
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return array;
    }

    //find birds of a specific color
    public static int[] findString (String[] list, String target){
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < list.length; i++){
            if (list[i].equals(target)){
                indices.add(i);
            }
        }
        int[] result = new int[indices.size()];
        for (int i = 0; i <indices.size(); i++){
            result[i] = indices.get(i);
        }
        return result;
    }

    public static String[] birdsOfColor(String[] colors, String target){
        int[] indexes = findString(colors, target);
        String[] birdNames = toStringArray("names.txt", 98);
        String [] birds = new String[indexes.length];
        for(int i = 0; i < indexes.length; i++) {
            birds[i] = birdNames[indexes[i]];
        }
        return birds;
    }

    public static void main(String[] args) {
        String colorFile = "colors.txt";
        // String dietFile = "diets.txt";
        // String nameFile = "names.txt";
        // String statusFile = "status.txt";
        int arraySize = 98;

        // String[] colorsArray = toStringArray(colorFile, arraySize);
        // System.out.println("String Array: " + Arrays.toString(colorsArray));

        // String[] dietArray = toStringArray(dietFile, arraySize);
        // System.out.println("String Array: " + Arrays.toString(dietArray));

        // String[] nameArray = toStringArray(nameFile, arraySize);
        // System.out.println("String Array: " + Arrays.toString(nameArray));

        // String[] statusArray = toStringArray(statusFile, arraySize);
        // System.out.println("String Array: " + Arrays.toString(statusArray));

        String[] colorsArray = toStringArray(colorFile, arraySize);
        String[] colorList = birdsOfColor(colorsArray, "Brown");
        System.out.println("Birds in the color brown: " + colorList);
    }
}