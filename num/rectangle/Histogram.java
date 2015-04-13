import java.util.Stack;

public class Histogram {
/*
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int max_area = Integer.MIN_VALUE;
        int peak = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            if (i < height.length - 1 && height[i] <= height[i + 1]) {
                continue;
            }
            peak = height[i];
            int min = height[i];
            for (int j = i; j >= 0; j--) {
                min = Math.min(min, height[j]);
                max_area = Math.max(max_area, (i - j + 1) * min );
            }
        }
        return max_area;
    }
    */
    
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[i] > stack.peek()) {
                stack.push(i);
            }
            else {
                int temp = 0;
                int h = stack.pop();
                if (stack.empty()) {
                    temp = h * (i )
                }
            }
        }
    }
}
