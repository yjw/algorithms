package nonleetcode;

import java.util.Iterator;

public class Peekable<T> implements Iterator<T> {
	private T top;
	private Iterator<T> iter;
	
	Peekable (Iterator<T> iter) {
		this.iter = iter;
		if (iter.hasNext()) {
			top = iter.next();
		}
	}
	
	public boolean hasNext() {
		return top != null ;
	}

	@Override
	public T next() {
		T item = top;
		if (iter.hasNext()) {
			top = iter.next();
		}
		else {
			top = null;
		}
		return item;
	}

	public T peek() {
		return top;
	}
}
