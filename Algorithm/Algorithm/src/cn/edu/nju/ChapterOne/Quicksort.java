package cn.edu.nju.ChapterOne;

import java.util.Arrays;

public class Quicksort {

	static int ramdom(int p, int r) {
		int i = (int) (Math.random() * (r - p + 1) + p);
		return i;
	}

	public static int partition(int[] arr, int p, int r) {
		int temp1 = ramdom(p, r);
		int temp2 = arr[temp1];
		arr[temp1] = arr[r];
		arr[r] = temp2;

		int pivot_element = arr[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (arr[j] <= pivot_element) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[r];
		arr[r] = temp;
		return i + 1;

	}

	public static void quickSort(int[] arr, int p, int r) {
		if (p < r) {
			int q = partition(arr, p, r);
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);

		}

	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 获取开始时间
		int[] arr = Utils.randomArr(2000);
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr)); // 要测试的程序或方法

		long end = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (end - start) + "ms");

	}
}
