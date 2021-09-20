package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method

		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);

		this.head.next = this.tail;
		this.tail.prev = this.head;

		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method

		// LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> lastNode = this.tail.prev;

		lastNode.next = newNode;
		newNode.prev = lastNode;
		newNode.next = this.tail;
		this.tail.prev = newNode;

		this.size += 1;

		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.

		if((index < 0) || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}

		if(this.size == 0) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> currNode = this.head.next;

		for(int i = 0; i < index; i++) {
			currNode = currNode.next;
		}

		return currNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method

		if((index < 0) || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}

		if(this.size == 0) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> currNode = this.head.next;

		for(int i = 0; i < index; i++) {
			currNode = currNode.next;
		}

		LLNode<E> prevNode = currNode.prev;
		LLNode<E> nextNode = currNode.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		this.size -= 1;

		return currNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
