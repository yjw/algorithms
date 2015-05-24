public class Test {
	public static void main (String[] args) {
		//int[][] array = {{1,0},{2,0},{3,1},{3,2}};
		int[][] array = {{0, 1}, {1, 0}};
		int count = 2;
		Schedule s = new Schedule();
		int[] t = s.findOrder(2, array);
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}
}