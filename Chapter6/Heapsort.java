import java.util.Random;
import java.util.Arrays;

public class Heapsort {

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		int[] arr = CREATE_ARR(n);
		Heap heap = new Heap();

		System.out.println("The unsorted array is " + Arrays.toString(arr));

		heap.BUILD_MAX_HEAP(arr);

		System.out.println("The heapified array is " + Arrays.toString(arr));

		heap.HEAPSORT(arr);

		System.out.println("The sorted array is " + Arrays.toString(arr));


	}

	public static int[]  CREATE_ARR(int n) {

		int[] arr = new int[n];
		Random random = new Random();

		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(50);
		}

		return arr;

	}
}

class Heap {
	

	public void MAX_HEAPIFY(int[] arr, int h, int i) {

		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;

		if (l < h && arr[l] > arr[i]) {
			largest = l;
		} 

		if (r < h && arr[r] > arr[largest]) {
			largest = r;
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			MAX_HEAPIFY(arr, h, largest);
		}

	}

	public void MIN_HEAPIFY(int[] arr, int h, int i) {

		int smallest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;

		if (l <= h && arr[l] < arr[i]) {
			smallest = l;
		} 

		if (r <= h && arr[r] < arr[smallest]) {
			smallest = r;
		}

		if (smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;

			MIN_HEAPIFY(arr, h, smallest);
		}

	}

	public void BUILD_MAX_HEAP(int[] arr) {

		int h = arr.length;

		for (int i = h/2 - 1; i >= 0; i--) {
			MAX_HEAPIFY(arr, h, i);
		}
	}

	public void HEAPSORT(int[] arr) {

		for (int i = arr.length - 1; i >= 1; i--) {

			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			MAX_HEAPIFY(arr, i, 0);
		}

	}

}

