// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer peekHold;
    Iterator<Integer> itr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr = iterator;
	    peekHold = itr.hasNext()? itr.next(): null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peekHold;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ans = peekHold;
	    peekHold = itr.hasNext()? itr.next(): null;
	    return ans;
	}

	@Override
	public boolean hasNext() {
	    return (peekHold != null);
	}
}