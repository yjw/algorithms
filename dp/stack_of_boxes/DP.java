package yset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DP {
	public ArrayList<Box> max_stack (Box[] boxes) {
		ArrayList<Box> res = new ArrayList<Box>();
		Arrays.sort(boxes, new comp());
		for (int i = 0; i < boxes.length; i++) {
			
		}
		return res;
	}
}

class comp implements Comparator<Box> {

	@Override
	public int compare(Box o1, Box o2) {
		if (o1.width < o2.width) {
			return -1;
		}
		if (o1.width < o2.width) {
			return 1;
		}
		return 0;
	}
}
