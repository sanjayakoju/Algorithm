import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        run(Dataset.arr);
        run(Dataset.arr1);
        run(Dataset.arr2);
        run(Dataset.arr3);
    }

    static void run(int[] arr) {
        var heap = new MaxHeap(arr);
        System.out.println("Heap before sort: " + heap);
        int comparisons = heap.sort();
        System.out.println("The number of data item comparisons is " + comparisons);
        System.out.println("Sorted array: " + heap.sorted() + "\n\n");
    }

    static class Dataset {
        static int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        static int[] arr1 = new int[] { 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15 };
        static int[] arr2 = new int[] { 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15 };
        static int[] arr3 = new int[] { 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9 };
    }
}

class MaxHeap {
    int[] arr;
    int size = 0;
    int[] sortedArr;

    MaxHeap(int[] arr) {
        this.arr = new int[arr.length + 1];
        System.arraycopy(arr, 0, this.arr, 1, arr.length);
        size = arr.length;
    }

    public int sort() {
        int comparisons = this.build();
        sortedArr = new int[this.arr.length - 1];
        for (int i = this.arr.length - 1; i > 0; i--) {
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            sortedArr[i - 1] = temp;
            comparisons += downHeap(1);
            this.size--;
        }

        return comparisons;
    }

    public void insert(int val) {
        arr[++size] = val;
    }

    public int size() {
        return size;
    }

    public String sorted() {
        return Arrays.toString(sortedArr);
    }

    public int build() {
        int comparisons = 0;
        for (int i = size / 2; i > 0; i--) {
            comparisons += downHeap(i);
        }
        return comparisons;
    }

    public int downHeap(int i) {
        int comparisons = 1;
        int max = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left < size && arr[left] > arr[max])
            max = left;
        if (right < size && arr[right] > arr[max])
            max = right;
        if (left < size && right < size && arr[right] < arr[left])
            max = left;

        if (max != i) {
            swap(arr, max, i);
            comparisons += downHeap(max);
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
