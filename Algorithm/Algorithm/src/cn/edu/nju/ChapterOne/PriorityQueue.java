package cn.edu.nju.ChapterOne;

import java.util.Arrays;

public class PriorityQueue {
	private int length;
	private int[] arr;

	public PriorityQueue(int[] arr) {
		length = arr.length;
		Heapsort.bulidMaxHeap(arr);
		this.arr = arr;
	}

	public int maximum() {
		return arr[0];

	}

	public Integer extravtMaximum() {
		if (length <= 0) {
			System.out.println("NO LEFT ELEMENT");
			return null;
		} else {
			int max = arr[0];
			arr[0] = arr[length - 1];
			int[] tempArr = Arrays.copyOf(arr, length - 1);
			arr = tempArr;
			Heapsort.maxHeapify(arr, 0);
			length--;
			System.out.println(max);
			return max;
		}
	}

	public void increaseKey(int i, int key) {
		if (i >= length) {
			System.out.println("INCREASE IS OUT OF RANGE");
		} else {
			if (key <= arr[i]) {
				System.out.println("ERROR: YOU DON NOT INCREASE!");
			} else {
				arr[i] = key;
				while (i > 0 && arr[i] > arr[(i - 1) / 2]) {
					int temp = arr[i];
					arr[i] = arr[(i - 1) / 2];
					arr[(i - 1) / 2] = temp;
					i = (i - 1) / 2;

				}
			}
		}

	}

	public void insert(int key) {
		int[] temp = new int[length + 1];
		System.arraycopy(arr, 0, temp, 0, length);
		arr = temp;
		length++;
		increaseKey(length-1, key);
		

	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {
		int[] arr = Utils.randomArr(10);
		 System.out.println(Arrays.toString(arr));
		PriorityQueue priorityQueue = new PriorityQueue(arr);
		priorityQueue.insert(20);
		System.out.println(priorityQueue);
	
	}
}
