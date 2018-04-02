package cn.edu.nju.ChapterOne;

import java.util.Arrays;

public class Insertsort {
	public static void insertSort(int[] arr) {
		int n = arr.length;
		int i, j;
		int key;
		for (j = 1; j < n; j++) {
			key = arr[j];
			for (i = j - 1; (i > -1) && (arr[i] > key); i--) {
				arr[i + 1] = arr[i];
			}
			arr[i + 1] = key;
		}

	}
	public static void main(String[] args) {
		int[] arr = Utils.randomArr(100);
		System.out.println(Arrays.toString(arr));
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
