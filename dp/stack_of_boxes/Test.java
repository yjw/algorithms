package yset;

import java.util.ArrayList;

//fixed direction dp

public class Test {
	public ArrayList<Box> max (Box[] boxes) {
		ArrayList<Box> res = new ArrayList<Box>();
		int max_height = 0;
		for (int i = 0; i < boxes.length; i++) {
			ArrayList<Box> item = create_stack_R(boxes, boxes[i]);
			int new_height = stackHeight(item);
			if (new_height > max_height) {
				max_height = new_height;
				res = item;
			}
		}
		return res;
	}
	
	private ArrayList<Box> create_stack_R (Box[] boxes, Box bottom) {
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canAbove(bottom)) {
				ArrayList<Box> new_stack = create_stack_R(boxes, boxes[i]);
				int new_height = stackHeight(new_stack);
				if (new_height > max_height) {
					max_height = new_height;
					max_stack = new_stack;
				}
			}
		}
		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		if (bottom != null) {
			max_stack.add(0, bottom);
		}
		return max_stack;
	}
	
	private int stackHeight(ArrayList<Box> stack) {
		int sum = 0;
		for (Box b : stack) {
			sum += b.height;
		}
		return sum;
	}
}