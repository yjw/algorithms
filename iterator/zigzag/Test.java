import java.util.ArrayList;

public class Test {
	public static void main (String[] args) {
		ArrayList<Character> l1 = new ArrayList<Character>();
		ArrayList<Character> l2 = new ArrayList<Character>();
		l1.add('1');
		l1.add('2');
		l1.add('3');
		l1.add('4');
		l1.add('5');
		l2.add('a');
		l2.add('b');
		l2.add('c');
		l2.add('d');
		l2.add('e');
		l2.add('f');
		l2.add('g');
		Iterator<Character> i1 = l1.iterator();
		Iterator<Character> i2 = l2.iterator();
		
	}
}