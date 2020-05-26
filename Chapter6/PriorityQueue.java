import java.util.Random;
import java.util.Arrays;

public class PriorityQueue {

	private int[] arr;
	private int heapsize;
	private int max;

	public PriorityQueue(int max) {
		this.max = max;
		this.heapsize = 0;
		arr = new int[this.max + 1];
		arr[0] = Integer.MAX_VALUE;
	}

	public void MAX_HEAPIFY(int i) {

		int largest = i;
		int l = 2*i;
		int r = 2+i + 1;

		if (l <= heapsize && arr[l] > arr[i]) {
			largest = l;
		}

		if (r <= heapsize && arr[r] > arr[largest]) {
			largest = r;
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;;

			MAX_HEAPIFY(largest);
		}

	}

	public int MAXIMUM() {
		return arr[1];
	}

	public int EXTRACT_MAXIMUM() {

		int max = arr[1];
		arr[1] = arr[heapsize--];
		MAX_HEAPIFY(1);

		return max;
	}

	public void CHANGE_KEY(int i, int key) {

		if (key < arr[i]) {
		
			arr[i] = key;
			MAX_HEAPIFY(i);

		} else {
			
			arr[i] = key;

			while (i > 1 && arr[i/2] < arr[i]) {

				int temp = arr[i];
				arr[i] = arr[i/2];
				arr[i/2] = temp;

				i = i/2;
			}
		}
	}

	public void INSERT(int key) {

		this.heapsize++;
		CHANGE_KEY(heapsize, key);

	}

	public void PRINT_HEAP() {
		
		int[] heap = Arrays.copyOfRange(arr, 1, heapsize+1);
		System.out.println(Arrays.toString(heap));

	}

	
	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);

		PriorityQueue queue = new PriorityQueue(n);
		Random rand = new Random();

		for (int i = 1; i < n/2; i++) {
		       	int num = rand.nextInt(100);
			queue.INSERT(num);
		}		

		System.out.println("Initial heap:");
		queue.PRINT_HEAP();
		System.out.println("Maximum: " + queue.MAXIMUM());

		System.out.println("Change root to 3");
		queue.CHANGE_KEY(1, 3);
		queue.PRINT_HEAP();
		System.out.println("Maximum: " + queue.MAXIMUM());

		System.out.println("Change n/2 to 400");
		queue.CHANGE_KEY(n/2, 400);
		queue.PRINT_HEAP();
		System.out.println("Maximum: " + queue.MAXIMUM());

		System.out.println("Extract maximum: " + queue.EXTRACT_MAXIMUM());
		System.out.println("Extract maximum: " + queue.EXTRACT_MAXIMUM());
		System.out.println("Extract maximum: " + queue.EXTRACT_MAXIMUM());
		System.out.println("Extract maximum: " + queue.EXTRACT_MAXIMUM());
		System.out.println("Extract maximum: " + queue.EXTRACT_MAXIMUM());
	
		System.out.println("Final heap:");
		queue.PRINT_HEAP();	

	}

}


