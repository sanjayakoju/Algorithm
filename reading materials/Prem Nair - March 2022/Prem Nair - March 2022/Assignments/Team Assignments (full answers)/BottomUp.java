public class BottomUp {

    static int comparisons;

    static void buildHeapBottomUp(int [] arr){

        for (int i = (arr.length/2)-1; i>=1;i--){
            downHeap(arr,i);
        }
    }

    static void downHeap(int [] arr, int i){

        int j = i;
        if(j>(arr.length)/2) return;

        comparisons++;
        if(j != maxChildIndex(arr, j)){
            int temp = arr[maxChildIndex(arr, j)];
            arr[maxChildIndex(arr, j)] = arr[i];
            arr[i] = temp;
            j = maxChildIndex(arr, j);
            downHeap(arr, j);
        }
    }

    static int maxChildIndex (int [] arr, int i){

        if(i <= (arr.length)/2){
        
            if (arr[i] > arr[2*i] && arr[i] > arr[(2*i)+1]){
                return i;
            } else if ( arr[2*i] > arr[i] && arr[2*i] > arr[(2*i)+1]){
                return 2*i;
            } else{
                return (2*i)+1;
            }
        } else return i;
        
    }

    public static void main (String[] args){
        int [] arr1 = new int [] {1 ,2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,0};
        int [] arr2 = new int [] {2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15,0};
        int [] arr3 = new int [] {4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15,0};
        int [] arr4 = new int [] {5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9,0};

        buildHeapBottomUp(arr4);
        System.out.println(comparisons);
    }
    
}
