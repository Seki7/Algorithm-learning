package cn.edu.nju.ChapterOne;

import java.util.Arrays;

public class MaxSubArr {
	public static void main(String[] args) {
		int[] arr = Utils.randomArr(20);
		// int[] arr = { -1, 2 };
		// Result res = findMaxCrossingSubArr(arr, 0, 2, 4);
		System.out.println(Arrays.toString(arr));
		Result res = findMaxSubArr(arr, 0, arr.length - 1);
		System.out.println(res);
	}

	public static Result findMaxCrossingSubArr(int[] arr, int low, int mid, int high) {
		Result res = new Result();
		int left_sum = arr[mid];
		int right_sum = 0;
		int i, j;
		res.setLeft(mid);
		res.setRight(mid);
		int sum = 0;
		for (i = mid; i >= low; i--) {
			sum = sum + arr[i];
			if (sum > left_sum) {
				left_sum = sum;
				res.setLeft(i);
			}
		}
		sum = 0;
		for (j = mid + 1; j <= high; j++) {
			sum = sum + arr[j];
			if (sum > right_sum) {
				right_sum = sum;
				res.setRight(j);
			}
		}
		res.setMax_sum(left_sum + right_sum);
		return res;

	}

	public static Result findMaxSubArr(int arr[], int low, int high) {
		Result totalRes = new Result();
		if (high == low) {
			totalRes.setLeft(low);
			totalRes.setRight(high);
			totalRes.setMax_sum(arr[low]);
		} else {
			int mid = (low + high) / 2;
			Result leftRes = findMaxSubArr(arr, low, mid);
			Result rightRes = findMaxSubArr(arr, mid + 1, high);
			Result crossingRes = findMaxCrossingSubArr(arr, low, mid, high);
			if (leftRes.getMax_sum() >= crossingRes.getMax_sum()) {
				totalRes = leftRes;
			} else {
				totalRes = crossingRes;
			}
			if (rightRes.getMax_sum() >= totalRes.getMax_sum()) {
				totalRes = rightRes;
			}
		}
		return totalRes;
	}
}

class Result {
	private int max_sum;
	private int left;
	private int right;

	public int getMax_sum() {
		return max_sum;
	}

	public void setMax_sum(int max_sum) {
		this.max_sum = max_sum;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	@Override
	public String toString() {

		return "最大子数组是从第" + getLeft() + "个到第" + getRight() + "个（从0开始计数），和是" + getMax_sum();
	}
}
