public class Heap2 {
	int[] heap;
	int size;
	int lastPosition;

	public Heap2(int[] array) {
		heap = array;
		this.size = array.length;
		lastPosition = array.length - 1;
	}

	public int findMax() {
		if (size > 0) {
			return heap[0];
		}
		return -1;
	}

	public int extractMax() {
		int max = heap[0];
		delete(0);
		return max;
	}

	public void insert(int x) {
		heap[lastPosition] = x;
		bottomUp(heap, lastPosition);
		lastPosition++;
	}

	// Delete element at location i O(logn)
	public void delete(int i) {
		heap[i] = heap[lastPosition];
		lastPosition--;
		size--;
		// One of these will do nothing.
		bottomUp(heap, i);
		topDown(heap, i);
	}

	public void bottomUp(int[] h, int i) {
		int parent = (int) Math.floor((i - 1) / 2);
		if (i > 0 && h[parent] < h[i]) {
			int temp = h[i];
			h[i] = h[parent];
			h[parent] = temp;
			bottomUp(h, parent);
		}
	}

	public void topDown(int[] h, int i) {
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;
		int largerChild;
		if (rightChild < size && h[rightChild] > h[leftChild]) {
			largerChild = rightChild;
		} else {
			largerChild = leftChild;
		}
		if (largerChild < size && h[largerChild] > h[i]) {
			int temp = h[i];
			h[i] = h[largerChild];
			h[largerChild] = temp;
			topDown(h, largerChild);
		}

	}

	// Create a heap from unsorted array (n is size of array)
	// You're only running siftDown on half of the array,
	// so it actually runs in O(n) rather than regular insertion
	// which would run in O(nlogn)
	public void heapify(int[] h) {
		for (int i = (int) Math.floor((size - 1) / 2); i >= 0; i--) {
			topDown(h, i);
		}
	}

	// returns a sorted array, using in-place heapsort
	// O(nlogn)
	public int[] heapSort() {
		heapify(heap);
		for (int i = size - 1; i >= 1; i--) {
			int max = extractMax();
			heap[i] = max;
		}
		return heap;
	}

	public void print() {
		System.out.println("Printing heap //////");
		for (int i = 0; i < heap.length; i++) {
			System.out.println(heap[i]);
		}
	}

	public static void main(String[] args) {
		int[] integers = { 36, 31, 20, 40, 23, 18, 15, 79, 27, 83 };
		Heap2 heapy = new Heap2(integers);
		int[] result = heapy.heapSort();
		System.out.println("printing result /////");
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}