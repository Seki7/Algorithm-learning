package cn.edu.nju.ChapterOne;

import java.util.Arrays;

public class Heapsort {
	public static void maxHeapify(int[] arr, int i) {
		if (2 * i + 2 > arr.length - 1) {
			if (2 * i + 1 > arr.length - 1) {
			} else if (arr[i] < arr[2 * i + 1]) {
				int temp = arr[i];
				arr[i] = arr[2 * i + 1];
				arr[2 * i + 1] = temp;
			}
		} else {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int largest = 0;
			if (arr[i] >= arr[left]) {
				largest = i;
			} else {
				largest = left;
			}
			if (arr[largest] < arr[right]) {
				largest = right;
			}
			if (arr[largest] != arr[i]) {
				int temp = arr[i];
				arr[i] = arr[largest];
				arr[largest] = temp;
				maxHeapify(arr, largest);
			}
		}
	}

	public static void bulidMaxHeap(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, i);

		}
	}

	public static void heapSort(int[] arr) {
		bulidMaxHeap(arr);
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			int[] tempArr = Arrays.copyOf(arr, i);
			maxHeapify(tempArr, 0);
			System.arraycopy(tempArr, 0, arr, 0, i);
		}
	}

	public static void main(String[] args) {
		int[] arr = Utils.randomArr(1000);
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		//Utils.exchangeOrder(arr);
		System.out.println(Arrays.toString(arr));
	}
}
