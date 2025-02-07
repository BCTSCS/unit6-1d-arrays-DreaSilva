import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class DataAnalyzer{
    private static int[] numbers = new int[100];
    
    //linear search
    public static int linearSearch(int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == target){
                return i;
            }
        }
        return -1;
    }

    //binary search
    public static int binarySearch(int[] numbers, int target){
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (numbers[mid] == target){
                return mid;
            }
            if (numbers[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int reverseSearch(int[] numbers, int target){
        for (int i = numbers.length - 1; i >= 0; i--){
            if (numbers[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int target = 7;
        String filePath = "number.txt";
        String[] fileContent = new String[100];
        File file = new File(filePath);

        try{
            Scanner input = new Scanner(file);
            int index = 0;
            while (input.hasNextLine()){
                String line = input.nextLine();
                fileContent[index] = line;
                index++;
            }
            input.close();
        }
        catch (Exception e){
            System.out.println("File not found");
        }

        for(int i = 0; i < fileContent.length; i++){
            numbers[i] = Integer.parseInt(fileContent[i]);
        }

        System.out.println("Linear Search: " + linearSearch(numbers, target));
        System.out.println("Reverse Search: " + reverseSearch(numbers, target));

        Arrays.sort(numbers);
        System.out.println("Binary Search: " + binarySearch(numbers, target));
    }
}