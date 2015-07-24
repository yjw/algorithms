public class Solution {
    public void reorder(int[] arr) {
        assert (arr != null);
        if (arr.length == 0) {
            return;
        }
        boolean smallHead = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (smallHead && arr[i] > arr[i + 1] || !smallHead && arr[i] < arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
            smallHead = !smallHead;
        }
    }
}
