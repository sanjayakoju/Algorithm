package lab;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n = 1000;
        for (int i = 1000;i<=10000;i=i+1000) {
            System.out.println("\n=============== When data is " + i + " ===============");
            int arr[] = loadData(i);
            long before1 = System.nanoTime() / 1000;
            program1(arr);
            long after1 = System.nanoTime() / 1000;
            System.out.println("Execution of Algo 1 : " + (after1 - before1));

            long before2 = System.nanoTime() / 1000;
            program2(arr);
            long after2 = System.nanoTime() / 1000;
            System.out.println("Execution of Algo 2 : " + (after2 - before2));

            long before3 = System.nanoTime() / 1000;
            program3(arr);
            long after3 = System.nanoTime() / 1000;
            System.out.println("Execution of Algo 3 : " + (after3 - before3));

            long before4 = System.nanoTime() / 1000;
            program4(arr);
            long after4 = System.nanoTime() / 1000;
            System.out.println("Execution of Algo 4 : " + (after4 - before4));

        }
    }

    static int[] loadData(int n) {
        Random random = new Random();
        int array[] = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(n);
        }
        return array;
    }

    static void program1(int arr[]) {
        int evenArray[] = new int[arr.length];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenArray[counter] = arr[i];
                counter++;
            }
        }

        int temp;
        for (int i = 0; i < counter; i++) {
            for (int j = i + 1; j < counter; j++) {
                if (evenArray[j] < evenArray[i]) {
                    temp = evenArray[i];
                    evenArray[i] = evenArray[j];
                    evenArray[j] = temp;
                }
            }
        }

        int sum = evenArray[counter - 1] - evenArray[0];

        System.out.println("Algo 1 Sum : " + sum);

    }

    static void program2(int arr[]) {
        int sum, temp, min = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
//                    temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        boolean minFound = false, maxFound = false ;
        int start = 0, end = arr.length -1;

        while (start<=end) {
            if (arr[start] % 2 == 0 && !minFound) {
                min = arr[start];
                minFound = true;
            }
            if (arr[end] % 2 == 0 && !maxFound) {
                max = arr[end];
                maxFound = true;
            }

            if (minFound && maxFound) {
                break;
            }
            start++;
            end--;
        }
        sum = max - min;
        System.out.println("Algo 2 Sum : "+sum);

    }

    static void program3(int arr[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
        }

        sum = max - min;
        System.out.println("Algo 3 sum : " + sum);
    }

    static void program4(int arr[]) {

        OptionalInt min = Arrays.stream(arr).filter(x -> x%2 == 0).min();
        OptionalInt max = Arrays.stream(arr).filter(x -> x%2==0).max();
        int sum = max.getAsInt() - min.getAsInt();

        System.out.println("Algo 4 Sum : "+sum);
    }

}
