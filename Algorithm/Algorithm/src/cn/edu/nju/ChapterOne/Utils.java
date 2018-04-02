package cn.edu.nju.ChapterOne;



public class Utils {

	public static int[] randomArr(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (n - 2 * Math.random() * n);
		}

		return arr;

	}

	public static void exchangeOrder(int[] arr) {
		int[] tempArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			tempArr[arr.length - 1 - i] = arr[i];
		}
		System.arraycopy(tempArr, 0, arr, 0, arr.length);
	}


}
