package nonleetcode;

import java.util.Iterator;

public class MyIterator<Character> implements Iterator<Character> {
	private Iterator<Character> i1;
	private Iterator<Character> i2;
	private boolean readfrom1;
	MyIterator(Iterator<Character> i1, Iterator<Character> i2) {
		this.i1 = i1;
		this.i2 = i2;
		readfrom1 = true;
	}
	
	public boolean hasNext() {
		return i1.hasNext() || i2.hasNext();
	}

	@Override
	public Character next() {
		if (i1.hasNext() && i2.hasNext()) {
			if (readfrom1) {
				readfrom1 = false;
				return i1.next();
			}
			else {
				readfrom1 = true;
				return i2.next();
			}
		}
		if (i1.hasNext()) {
			return i1.next();
		}
		else {
			return i2.next();
		}
	}
}
