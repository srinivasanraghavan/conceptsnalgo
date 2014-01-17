package com.insanelygreat;

import java.awt.Point;
import java.util.ArrayList;

public class RescuriveAlgos {
	static ArrayList<Point> current_path = new ArrayList<Point>();

	public static void convertNumberToString(int n) {

		if (n > 10) {
			convertNumberToString(n / 10);
		}
		System.out.println(n);

	}

	public static int F(int n) {

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int val = F(n - 1) + F(n - 2);
		System.out.println(val);
		return val;

	}

	public static boolean getPaths(int x, int y) {
		Point p = new Point(x, y);
		current_path.add(p);
		if (0 == x && 0 == y)
			return true; // current_path
		boolean success = false;
		if (x >= 1) { // Try right
			success = getPaths(x - 1, y); // Free! Go right
		}
		if (!success && y >= 1) { // Try down
			success = getPaths(x, y - 1); // Free! Go down
		}
		if (!success) {
			current_path.remove(p); // Wrong way!
		}
		return success;
	}

	public static ArrayList<ArrayList<Integer>> getSubsets(
			ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

	public static ArrayList<ArrayList<Integer>> getSubsets2(
			ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			while (k > 0) {
				if ((k & 1) > 0) {
					subset.add(set.get(index));
				}
				k >>= 1;
				index++;
			}
			allsubsets.add(subset);
		}
		return allsubsets;
	}

}
