public class TopDown {

    static int comparisons = 0;

    static void buildHeapTopDown(int [] arr){
        for(int i = 0; i < arr.length; i++){
            upHeap(arr, i);
        }
    }
    
    static void upHeap(int [] arr, int i){
        int j = i;
        if (j<=1) return;
        comparisons++;
        if(arr[j] > arr[j/2]){
            int temp = arr[j];
            arr[j] = arr[j/2];
            arr[j/2] = temp;
            upHeap(arr, j/2);
        }
    }

    public static void main (String[] args){
        int [] arr1 = new int [] {0,1 ,2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int [] arr2 = new int [] {0,2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        int [] arr3 = new int [] {0,4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int [] arr4 = new int [] {0,5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};

        buildHeapTopDown(arr1);
        System.out.println(comparisons);
    }

}


