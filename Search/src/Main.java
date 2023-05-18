import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] binarySearch(int[] arr, int target) {
        List<Integer> indices = new ArrayList<>();
        int left = 0, right = arr.length - 1, count = 0;
        while (left <= right && count < arr.length) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                indices.add(mid);
                int leftsub = mid - 1;
                while (leftsub >= 0 && arr[leftsub] == target) {
                    indices.add(leftsub);
                    leftsub--;
                }
                int rightsub = mid + 1;
                while (rightsub < arr.length && arr[rightsub] == target) {
                    indices.add(rightsub);
                    rightsub++;
                }
                indices.sort(Integer::compareTo);
                return indices.stream().mapToInt(Integer::intValue).toArray();
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            count++;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size, index;
        do {
            try {
                System.out.print("Enter the size of the array (>= 0): ");
                size = scanner.nextInt();

                if (size < 0) {
                    System.out.println("Invalid size! Please enter a non-negative integer.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                size = -1;
                scanner.next();
            }

        } while (size < 0);
        int[] array = new int[size];
        try {
            System.out.print("What number do you want to find: ");
            index = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            index = -1;
            scanner.next();
        }
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        System.out.println("Unsorted array: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
        int[] result = binarySearch(array, index);
        if (result.length > 0) {
            System.out.println("Found " + index + " at positions: " + Arrays.toString(result));
        } else {
            System.out.println("Not found " + index + " in array");
        }
    }
}
