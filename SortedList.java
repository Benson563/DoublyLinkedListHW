/*
  SortedList class is a doubly linked list that save elements in a sorted, increasing order. 
 */

import java.util.Iterator;

public class SortedList<T extends Comparable<T>> implements Iterable<T> {

    public Node<T> head;
    public Node<T> tail;

    public SortedList() {
        head = null;
        tail = null;

    }

    /*
     * Copy constructor:
     * It gets a another sorted list, and copies it to this newly constructed
     * SortedList.
     */
    public SortedList(SortedList<T> l) {
         SortedList<T> newSortL = l;


    }

    /*
     * Add element:
     * It adds the passed in element to the list, such that the list remains sorted.
     *
     * NOTE: if there is another element with the same value, insert the new
     * one just "before the next larger element". We will be writing element classes
     * such that we can test if you inserted according to this spec.
     *
     * EX: if the list has the following elements: 1->2->2->6->11
     *     and you need to insert an element with value, it must be inserted
     *     between the second 2 and 6.
     */
    public void add(T elem) {
        Node<T> newElement = new Node(elem);
        // TODO
        if (this.isEmpty()) {
            this.head = newElement;
            this.tail = newElement;
        } else {
            if (this.head == this.tail) {
                if (this.tail.elem.compareTo(elem) <= 0) {  //new elem is bigger than tail
                    this.tail.next = newElement;
                    tail = tail.next;
                    tail.prev = head;
                } else {
                    this.tail.prev = newElement;
                    head = tail.prev;
                    head.next = tail;
                }

            } else {
                if (head.elem.compareTo(elem) >= 0) {
                    head.prev = newElement;
                    newElement.next = head;
                    head = newElement;

                } else {
                    Node<T> compare = tail;
                    if (elem.compareTo(compare.elem) >= 0) {
                        compare.next = newElement;
                        newElement.prev = compare;
                        tail = newElement;

                    } else {


                        while (compare.elem.compareTo(elem) > 0) {
                            compare = compare.prev;

                        }
                        newElement.prev = compare;
                        newElement.next = compare.next;
                        compare.next = newElement;

                    }
                }
            }
        }

    }

    /*
     * Remove given element if exits:
     * Look for the element, and if it exits, delete it.
     *
     *
     * NOTE: if more than one copy of the element exists, all need to be deleted.
     *
     * Complexity: if there is more than one element equal to
     * the passed in element, you should not look up the next
     * element starting from the head or tail. In other words,
     * if you have a list of n elements, and all the elements are equal,
     * the complexity of deleting all of them must be linear: O(n).
     *
     * EX: if the list has following elements: 1->2->2->6->11
     *     and we would like to delete 2, the new list should
     *     look like: 1->6->11
     */
    public void remove(T elem) {
        // TODO
        Node<T> pointer = this.head;
        while(pointer.elem != elem) {
            pointer = pointer.next;
        }
       // while(pointer.next.elem != null){
        Node<T> prevOfPointer = pointer.prev;
        Node<T> nextOfPointer = pointer.next;
        while(nextOfPointer.elem == elem ) {
            nextOfPointer = nextOfPointer.next;

        }
        prevOfPointer.next = nextOfPointer;
        nextOfPointer.prev = prevOfPointer;





    }

    /*
     * Remove the passed in node:
     * In this method, you do not search for the element to be deleted,
     * rather, you are given a reference to a node that need to be deleted.
     *
     * NOTE: if the reference is "null", just return.
     */
    public void remove(Node<T> n) {
        // TODO
        Node<T> pointer = this.head;
        while(pointer != n) { // after while loop, should be at position to remove;
            pointer = pointer.next;
        }
        if(pointer == this.head){ // head case
            this.head = head.next;
            this.head.prev = null;
        }

        if(pointer == this.tail){ //tail case
            Node<T> holder = this.tail.prev;
            tail = holder;
            tail.next = null;
        }

        if(pointer != this.head && pointer != this.tail){ //middle case
            Node<T> frontOfP = pointer.next;
            Node<T> backOfP = pointer.prev;
            frontOfP.prev = backOfP;
            backOfP.next = frontOfP;

        }

    }

    /*
     * Test whether the list is empty or not
     */
    public boolean isEmpty() {
        //TODO
        if (this.head == null) {
            return true;
        }
        return false;
    }

    /*
     * Search for the passed in element:
     * If the given element is found, return a reference to the first
     * occurrence of the element in the list.
     *
     */
    public Node<T> search(T elem) {

        // TODO
        return null;
    }

    /* Return the index of the given element if found.
     * return -1 if it does not exist
     */
    public int indexOf(T elem) {
        // TODO
        Node<T> pointer = this.head;
        boolean check = false;
        int counter = 0;
        while(pointer.elem != null){
            if(pointer.elem != elem) {
                counter = counter + 1;
                pointer = pointer.next;
            }
            else{
                return counter;}
        }
        return -1;
    }

    /*
     * Return a list iterator.
     */
    @Override
    public Iterator<T> iterator() {

        /*Might need to change this. We provided Default constructor
         * to get rid of compiler errors
         * */
        // TODO
        return new SortedListIterator<>();
    }

    /*
     * Checks if the passed in list is equal to this list.
     *
     * NOTE: we are checking if the whole list matches the
     * passed in list.
     */
    @Override
    public boolean equals(Object obj) {
        // TODO

        return false;
    }


    public void printList() {
        if (head == null)
            return;
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.elem.toString());
            temp = temp.next;
        }
    }

}
