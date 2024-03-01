import java.util.Arrays;
public class BuildHeapTopDown {
    public static void main(String[] args) {
        // int[] arr = new int[] { 0, 50, 24, 35, 47, 12, 5, 65, 20, 8 };
        int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        MaxHeap heap = new MaxHeap(arr1.length);
        for (int i = 0; i < arr1.length; i++) {
            heap.insert(arr1[i]);
        }
        int comparisons = heap.build();
        System.out.println("The number of data item comparisons is " + comparisons);
        System.out.println("Heap: " + heap);
    }
}
class MaxHeap {
    int[] arr;
    int size = 0;
    MaxHeap(int length) {
        arr = new int[length + 1];
    }
    public void insert(int val) {
        arr[++size] = val;
    }
    public int build() {
        int comparisons = 0;
        for (int i = 1; i <= size; i++) {
            comparisons += upHeap(arr, i);
        }
        return comparisons;
    }
    public int upHeap(int[] arr, int i) {
        int comparisons = 0;
        int index = i;
        comparisons = index > 1 ? 1 : 0;
        while (index > 1 && arr[index] > arr[index / 2]) {
            swap(arr, index, index / 2);
            index = index / 2;
            if (index > 1)
                comparisons += 1;
        }
        return comparisons;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    @Override
    public String toString() {
        return Arrays.toString(arr) + " of size: " + size;
    }
}