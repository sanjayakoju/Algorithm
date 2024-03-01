package lab2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 20;
        int arr[] = loadData(n);
        int thirdMax = algo1(arr);
    }

    private static int algo1(int arr[]) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            if (firstMax < arr[i]) {
                firstMax = arr[i];
            }
        }

        for (int j =0;j<arr.length;j++) {

        }
        return 0;
    }

    static int[] loadData(int n) {
        int returnArr[] = new int[n];
        Random random = new Random();
        for (int i=0;i<n;i++) {
            returnArr[i] = random.nextInt(n);
        }

        return returnArr;
    }
}
