import java.util.Random;

public class Shuffler {
	public void shuffle (int[] array) {
		assert(array.length > 0);
		for (int i = 1; i < array.length; i++) {
			Random r = new Random();
			int rand = r.nextInt(i + 1);
			int exch = array[i];
			array[i] = array[rand];
			array[rand] = exch;
		}
	}
}