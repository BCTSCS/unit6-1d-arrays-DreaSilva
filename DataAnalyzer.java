public class DataAnalyzer{
    private static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    
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
        System.out.println("Linear Search: " + linearSearch(numbers, target));
        System.out.println("Binary Search: " + binarySearch(numbers, target));
        System.out.println("Reverse Search: " + reverseSearch(numbers, target));
    }

}