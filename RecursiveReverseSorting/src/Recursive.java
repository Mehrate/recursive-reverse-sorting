
/*
 * This program implements a recursive reverse sorting algorithm.  
 */
import java.util.ArrayList;
import java.util.List;

public class Recursive {
	private ArrayList<Integer> arr;

	public Recursive(ArrayList<Integer> arr) {
		this.arr = arr;
	}

	/*
	 * Read the size of the list O(n) Recursive Bubble Sort On(n) Write O(n)
	 * 
	 * T(n) = T(n) + T(n) + T(n^2) + T(n) =O(n) + O(n) + O(n^2) + O(n) =O(3n) +
	 * O(n^2) = O(n^2)
	 * 
	 */

	public static void bubbleSortList(List<Integer> list) {
		if (list.size() == 1) {
			return;
		}
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) < list.get(i + 1)) {
				int hold = list.get(i);
				list.set(i, list.get(i + 1));
				list.set(i + 1, hold);
			}
		}
		bubbleSortList(list.subList(0, list.size() - 1));
	}
}