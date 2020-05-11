import java.util.Random;
import java.util.Arrays;

public class MaxSubarray {

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);

		int[] arr = create_rand_subarray(n);
		
		long start1 = System.nanoTime();
		int[] brute = FIND_MAXIMUM_SUBARRAY_BRUTE(arr);
		long time1 = System.nanoTime() - start1;

		long start2 = System.nanoTime();
		int[] dac = FIND_MAXIMUM_SUBARRAY(arr, 0, n-1);
		long time2 = System.nanoTime() - start2;

		long start3 = System.nanoTime();
		int[] combined = FIND_MAX_CROSSING_SUBARRAY_COMBINED(arr, n);
		long time3 = System.nanoTime() - start3;

		System.out.println("The array is " + Arrays.toString(arr));
		System.out.println("The brute force method took " + time1 + " ns and returned " + Arrays.toString(brute));
		System.out.println("The divide & conquer method took " + time2 + " ns and returned " + Arrays.toString(dac));
		System.out.println("The combined method took " + time3 + " ns and returned " + Arrays.toString(combined));

	}

	public static int[] create_rand_subarray(int n) {

		int[] arr = new int[n];
		Random random = new Random();

		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(30 + 10) - 10;
		}

		return arr;

	}

	public static int[] FIND_MAX_CROSSING_SUBARRAY_COMBINED(int[] arr, int n) {

		if (n < 230) {
			return FIND_MAXIMUM_SUBARRAY_BRUTE(arr);
		} else {
			return FIND_MAXIMUM_SUBARRAY(arr, 0, n-1);
		}
	}

	public static int[] FIND_MAX_CROSSING_SUBARRAY(int[] arr, int low, int mid, int high) {

		int leftsum = Integer.MIN_VALUE;
		int sum = 0;
		int maxleft = 0;

		for (int i = mid; i >= 0; i--) {
			sum += arr[i];
			if (sum > leftsum) {
				leftsum = sum;
				maxleft = i;
			}
		}

		int rightsum = Integer.MIN_VALUE;
		sum = 0;
		int maxright = 0;

		for (int i = mid+1; i <= high; i++) {
			sum += arr[i];
			if (sum > rightsum) {
				rightsum = sum;
				maxright = i;
			}
		}

		int[] res = new int[] {maxleft, maxright, leftsum+rightsum};
		return res;

	}

	public static int[] FIND_MAXIMUM_SUBARRAY(int[] arr, int low, int high) {
		
		if (high == low) {
			return new int[] {low, high, arr[low]};
		} else {

			int mid = (low + high)/2;

			int[] left = FIND_MAXIMUM_SUBARRAY(arr, low, mid);
			int[] right = FIND_MAXIMUM_SUBARRAY(arr, mid+1, high);
			int[] cross = FIND_MAX_CROSSING_SUBARRAY(arr, low, mid, high);		
		
			if (left[2] > right[2] && left[2] > cross[2]) {
			       	return left;
			} else if (right[2] > left[2] && right[2] > cross[2]) { 
				return right;
			} else {
			       	return cross;
			}
		}
	}

	public static int[] FIND_MAXIMUM_SUBARRAY_BRUTE(int[] arr) {

		int low = 0;
		int high = 0;
		int maxsum = Integer.MIN_VALUE;
		int sum = 0;
	
		int left = 0;
		int right = 0;

		for (int i = 0; i < arr.length; i++) {
			sum = 0;

			for (int j = i; j < arr.length; j++) {
				sum += arr[j];

				if (sum > maxsum) {
					maxsum = sum;
					left = i;
					right = j;
				}
			}
		}

		int[] res = new int[] {left, right, maxsum};	
		return res;
			
	}

}

