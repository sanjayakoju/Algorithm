package org.example;

import java.util.Random;

public class Lab2 {

    public static void main(String[] args) {
//        int size = 5000;
//               int [] userArray = {52,52,52,3,44,50,4,2,3,33,54};
//        System.out.println(algo1(userArray));

        for (int i=1000;i<=10000;i=i+1000) {
            int[] arr = initializedArray(i);
//        int [] userArray = {52,54,54,3,44,50,4,2,3,33,54};

            System.out.println("====== Input Data "+i+ "===========");
            Long beforeAlgo1 = System.nanoTime() / 1000;
            int thirdLargest = algo1(arr);
            System.out.println("The third highest from Algo1 is : " + thirdLargest);
            Long afterAlgo1 = System.nanoTime() / 1000;
            System.out.println("Execution time of Algo1:  " + (afterAlgo1 - beforeAlgo1));
            Long beforeAlgo2 = System.nanoTime() / 1000;
            int algo2ThirdLargest = algo2(arr);
            System.out.println("The third largest from Algo2 is: " + algo2ThirdLargest);
            Long afterAlgo2 = System.nanoTime() / 1000;
            System.out.println("Execution time of Algo2:  " + (afterAlgo2 - beforeAlgo2));
        }
    }

    static int[] initializedArray(int size){
        int[] arr = new int[size];
        for (int i = 0; i<size; i++){
            arr[i]= new Random().nextInt(10);
        }
        return arr;
    }

    static int algo1(int[] arr){
        int firstMax = Integer.MIN_VALUE;
        int firstMaxIndex= 0;

        for (int i = 0; i<arr.length;i++){
            if (arr[i]>firstMax){
                firstMax = arr[i];
                firstMaxIndex = i;
            }
        }

        int secondMax = Integer.MIN_VALUE;
        int secondMaxIndex = 0;
        for (int i = 0; i<arr.length;i++){
            if (arr[i]>secondMax && i!=firstMaxIndex){
                secondMax = arr[i];
                secondMaxIndex = i;
            }
        }

        int thirdMax = Integer.MIN_VALUE;
        for (int i = 0; i<arr.length;i++){
            if (arr[i]>thirdMax && i!=firstMaxIndex && i!= secondMaxIndex){
                thirdMax = arr[i];
            }
        }
//        System.out.println("first ="+firstMax);
//        System.out.println("secondMax ="+secondMax);
//        System.out.println("thirdMax ="+thirdMax);
        return thirdMax;
    }


    static int algo2(int[] arr){

        int max = Integer.MIN_VALUE;
        int preMax = max;
        int prePreMax = max;

        for (int i = 0; i<arr.length; i++){
            if (max <= arr[i]){
                prePreMax = preMax;
                preMax = max;
                max = arr[i];
            }else if (preMax<= arr[i]){
                prePreMax = preMax;
                preMax= arr[i];
            }else if (prePreMax <= arr[i]){
                prePreMax = arr[i];
            }
        }

//        System.out.println("lagest "+max);
//        System.out.println("second larget "+preMax);
//        System.out.println("third larget "+prePreMax);
        return prePreMax;
    }
}
