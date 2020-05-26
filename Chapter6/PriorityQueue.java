import java.util.Random;
import java.util.Arrays;

public class PriorityQueue {

	public static int heapsize = -1;

	public static void MAX_HEAPIFY(int[] arr, int i) {

		int largest = i;
		int l = 2*i + 1;
		int r = 2+i + 2;

		if (l < heapsize && arr[l] > arr[i]) {
			largest = l;
		}

		if (r < heapsize && arr[r] > arr[largest]) {
			largest = r;
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;;

			MAX_HEAPIFY(arr, largest);
		}

	}

	public static void BUILD_MAX_HEAP(int[] arr) {

		for (int i = heapsize/2; i > 0; i--) {
			MAX_HEAPIFY(arr, i);
		}

	}

	public static int MAXIMUM(int[] arr) {
		return arr[0];
	}

	public static int EXTRACT_MAXIMUM(int[] arr) {

		int max = arr[0];
		arr[0] = arr[heapsize];
		heapsize--;
		MAX_HEAPIFY(arr, 0);

		return max;
	}

	public static void CHANGE_KEY(int[] arr, int i, int key) {

		if (key < arr[i]) {
		
			arr[i] = key;
			MAX_HEAPIFY(arr, i);

		} else {

			while (i > 0 && arr[i/2] < arr[i]) {

				arr[i] = arr[i/2];
				i /= 2;
			}

			arr[i] = key;
		}
	}

	public static void INSERT(int[] arr, int key) {

		heapsize++;
		arr[heapsize] = -1*100000;
		CHANGE_KEY(arr, heapsize, key);

	}

	public static void PRINT_HEAP(int[] arr) {
		
		System.out.print("[");

		for (int i = 1; i <=heapsize; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("]");

	}

	
	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);

		if (n < 8) {
			System.err.println("n must be greater than 8");
		}

		int arr[] = new int[n];

		INSERT(arr, 20);
		INSERT(arr, 10);
		INSERT(arr, 7);
		INSERT(arr, 19);
		INSERT(arr, 100);
		INSERT(arr, 9);
		INSERT(arr, 71);
		INSERT(arr, 83);

		System.out.println("Initial heap:");
		PRINT_HEAP(arr);
		System.out.println("Maximum: " + MAXIMUM(arr));

		System.out.println("Change root to 3");
		CHANGE_KEY(arr, 0, 3);
		PRINT_HEAP(arr);
		System.out.println("Maximum: " + MAXIMUM(arr));

		System.out.println("Change n to 400");
		CHANGE_KEY(arr, n, 400);
		PRINT_HEAP(arr);
		System.out.println("Maximum: " + MAXIMUM(arr));

		System.out.println("Extract maximum: " + EXTRACT_MAXIMUM(arr));
		System.out.println("Extract maximum: " + EXTRACT_MAXIMUM(arr));	
		System.out.println("Extract maximum: " + EXTRACT_MAXIMUM(arr));
		System.out.println("Extract maximum: " + EXTRACT_MAXIMUM(arr));
		System.out.println("Extract maximum: " + EXTRACT_MAXIMUM(arr));
	
		System.out.println("Final heap:");
		PRINT_HEAP(arr);	

	}

}


