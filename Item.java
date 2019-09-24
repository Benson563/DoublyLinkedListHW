
public class Item implements Comparable<Item> {

	private Integer val;

	public Item(int val) {
		this.val = val;
	}

	
	public Item(Item it) {
		this.val = it.val;
	}

	@Override
	public String toString() {
		return val.toString();
	}

	/*
	 * Override compare to provide comparison results.
	 */
	@Override
	public int compareTo(Item arg0) {
		// TODO
		return val.compareTo(arg0.val);
	}

}
