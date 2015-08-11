//This is an algorithm from CLRS

public class Solution {
    public int[] max_min(int a[]) {
        int max = 0, min = 0;
        int len = a.length;
        if(len <= 0) {
            return null;
        }
        if(len == 1) {
            max = min = a[0];
            int[] ret = new int[2];
            ret[0] = min;
            ret[1] = max;
            return ret;
        }
        for (int i = 0; i < len - 1; i += 2) {
            if(i < len && a[i] < a[i + 1]) {
                swap(a, i, i+1);
            }
        }
        max = a[0];
        for (int i = 2; i < len - 1; i += 2) {
            if(max < a[i]) {
                max = a[i];
            }
        }
        min = a[1];
        for (int i = 1; i < len - 1; i += 2) {
            if(min > a[i]) {
                min = a[i];
            }
        }
        int[] ret = new int[2];
        ret[0] = min;
        ret[1] = max;
        return ret;
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}