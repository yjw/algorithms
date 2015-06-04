import java.util.HashMap;

public class Container {
	private int[] array;
	private HashMap<Integer, Integer> map;
	private int count;
	
	Container(int cap) {
		array = new int[cap];
		map = new HashMap<Integer, Integer>();
		count = 0;
	}
	
	public void add (int num) {
		array[count] = num;
		map.put(num, count);
		count++;
	}
	
	public void delete (int num) {
		int index = map.get(num);
		map.remove(num);
		count--;
		array[index] = array[count];
	}
	
	public int random () {
		return array[rand(count) % count];
	}
}