import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void selectionSort(int []arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
        }
    public static void bubbleSort(int []arr){
        for (int i=0;i< arr.length-1;i++){
            for (int j=0;j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void insertionSort(int []arr){
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
    public static void quickSort(int []arr, int left, int right){
        if(left<right){
            int pivot= partition(arr,left,right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }
    public static int partition(int []arr, int left,int right){
        int pivot=arr[right];
        int i=left-1;
        for (int j = left; j <right ; j++) {
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1,right);
        return i+1;
    }
    public static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void mergeSort(int []arr){
        if(arr.length<2)
            return;
        int mid=arr.length/2;
        int[] left=new int[mid];
        int[] right= new int[arr.length-mid];
        System.arraycopy(arr,0,left,0,mid);
        System.arraycopy(arr,mid,right,0,arr.length-mid);
        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }
    public static void merge(int[]left, int []right,int[]swap){
        int x= left.length;
        int y= right.length;
        int i=0,j=0,k=0;
        while (i<x&&j<y){
            if(left[i]<right[j])
                swap[k++]=left[i++];
            else
                swap[k++]=right[j++];
        }
        while(i<x)
            swap[k++]=left[i++];
        while (i<y)
            swap[k++]=right[j++];
    }
    public static void main(String []args ) {
        Scanner scanner = new Scanner(System.in);
        int size;
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
        for (int i = 0; i < size; i++) {
            try {
                System.out.print("Enter element " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                i--;
                scanner.next();
            }
        }
        insertionSort(array);
            System.out.println(Arrays.toString(array));
    }
    }

