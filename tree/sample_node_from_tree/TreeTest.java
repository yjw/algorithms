public class TreeTest {
	public static void main (String[] args) {
		Solution t = new Solution();
		TreeNodeTotal t1 = new TreeNodeTotal(1);
		TreeNodeTotal t2 = new TreeNodeTotal(2);
		TreeNodeTotal t3 = new TreeNodeTotal(3);
		TreeNodeTotal t4 = new TreeNodeTotal(4);
		TreeNodeTotal t5 = new TreeNodeTotal(5);
		TreeNodeTotal t6 = new TreeNodeTotal(6);
		t1.left = t2;
		t2.left = t3;
		t3.left = t4;
		t3.right = t5;
		t5.left = t6;
		//t.rand_node(t1);
		int[] res = new int[6];
		for (int i = 0; i < 100000; i++) {
			res[t.rand_node(t1).val- 1]++;
		}
		for (int i = 0; i < 6; i++) {
			System.out.println((double)res[i] / 100000.0);
		}
	}
}