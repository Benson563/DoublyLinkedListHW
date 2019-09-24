
public class Main {
	public static void main(String args[]) {
		/*
		 * The test here is very simple one. You need to 
		 * design your tests to test each and every functionality on 
		 * its own, then in interaction with other functionalities
		 * in the class to be confident of the correctness of your work.
		 */
		//TODO
		
		SortedList<Item> L = new SortedList<>();
		L.add(new Item(5));
		L.printList();
		System.out.println();
		L.add(new Item(2));
		L.printList();
		System.out.println();
		L.add(new Item(66));
		L.printList();
		System.out.println();
		L.add(new Item(6));
		L.printList();
		System.out.println();
		L.add(new Item(1));
		L.printList();

	}
}
