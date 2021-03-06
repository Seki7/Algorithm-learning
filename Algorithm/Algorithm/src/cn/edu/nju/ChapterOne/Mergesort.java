package cn.edu.nju.ChapterOne;

import java.util.Arrays;

public class Mergesort {
	public static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		System.arraycopy(temp, 0, arr, low, high - low + 1);
	}

	public static void mergeSort(int[] arr, int low, int high) {
		int mid = (high + low) / 2;
		if (high > low) {
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);

		}
	} 

	public static void main(String[] args) {
		int[] arr = Utils.randomArr(100);
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}
}
