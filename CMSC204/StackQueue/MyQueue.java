package assignment2;

import java.util.ArrayList;


public class MyQueue<T> implements QueueInterface<T>{
	
	private ArrayList<T> queue;
	private int size;
	private final int DEFAULT_SIZE = 20;
	
	//takes and integer as the size of the queue
	public MyQueue(int size) {
		queue = new ArrayList<>(size);
		this.size = size;
	}
	
	//uses default as the size of the queue
	public MyQueue() {
		queue = new ArrayList<>();
		size = DEFAULT_SIZE;
	}

	//Determines if the queue is empty
	@Override
	public boolean isEmpty() {
		return queue.isEmpty() ? true : false;
	}

	//Determines if the queue is full
	@Override
	public boolean isFull() {
		return queue.size() == size ? true : false;
	}

	//Deletes and returns the element at the front of the queue
	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) 
			throw new QueueUnderflowException();
		
		T dequeuedItem = queue.get(0);
		queue.remove(0);
		return dequeuedItem;
	}

	//Returns number of elements in the queue
	@Override
	public int size() {
		return queue.size();
	}

	//Adds an element to the end of the queue
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		//Throw error if the queue is full
		if(isFull()) {
			throw new QueueOverflowException();
		}
		//else add the element
		queue.add(e);
		//and return true if it was added to the end of the queue
		if(e.equals(queue.get(queue.size()-1))) {
			return true;
		}
			
		return false;
	}
	
	//Returns the string representation of the queue
	@Override
	public String toString() {
		String str = "";
		//System.out.println("Delimiter: ");
		for (T i : queue) {
			str += i;
		}
		//System.out.println(s);
		return str;
	}
	
	//Returns the string representation of the queue with a delimiter between elements
	@Override
	public String toString(String delimiter) {
		String str = "";
		//System.out.println("Delimiter: " + delimiter);
		for (T i : queue) {
			if (i.equals(queue.get(queue.size()-1)))
				str += i;
			else str += i + delimiter; 
			
		}
		//System.out.println(s);
		return str;
	}

	//fills the queue with elements of the ArrayList parameter
	@Override
	public void fill(ArrayList<T> list) {
		//Copy list 
		ArrayList<T> copy = new ArrayList<T>(list.size());
		for(T i : list) {
			copy.add(i);
		}
		//add the elements of copy to the queue
		for(T i : copy) {
			queue.add(i);
		}
	}
}
