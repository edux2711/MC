package assignment2;

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{

	private ArrayList<T> stack;
	private int size;
	private final int DEFAULT_SIZE = 20;
	
	//Constructor, takes an int as the size of the stack
	public MyStack(int size) {
		stack = new ArrayList<>(size);
		this.size = size;
	}
	
	//Constructor, makes the size equal to the default size
	public MyStack() {
		stack = new ArrayList<>();
		size = DEFAULT_SIZE;
	}
	
	//Determines if the stack is empty
	@Override
	public boolean isEmpty() {
		return stack.isEmpty() ? true : false;
	}

	//Determines if the stack is full
	@Override
	public boolean isFull() {
		return stack.size() == size ? true : false;
	}

	//Deletes and returns the element at the top of the stack
	//throws error if the stack is empty
	@Override
	public T pop() throws StackUnderflowException {
		if (stack.isEmpty()) 
			throw new StackUnderflowException();
		
		T poppedItem = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		
		return poppedItem;
	}

	//Returns the element at the top of the stack
	//throws error if the stack is empty
	@Override
	public T top() throws StackUnderflowException {
		if (stack.isEmpty()) 
			throw new StackUnderflowException();
		
		T top = stack.get(stack.size()-1);
	
		return top;
	}

	//Return the number of elements in the stack
	@Override
	public int size() {
		return stack.size();
	}

	//Adds an element to the top of the stack, returns true if the add was succesful
	//throws error if the stack is full
	@Override
	public boolean push(T e) throws StackOverflowException {
		//throw an error if the stack is full
		if(isFull()) {
			throw new StackOverflowException();
		}
		//else add the element
		stack.add(e);
		//and return true if it was added to the end of the stack
		if(e.equals(stack.get(stack.size()-1))) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		//System.out.println("Delimiter: ");
		for (T i : stack) {
			s += i;
		}
		//System.out.println(s);
		return s;
	}
	
	public String toString(String delimiter) {
		String s = "";
		for (T i : stack) {
			if (i.equals(stack.get(stack.size()-1)))
				s += i;
			else s += i + delimiter; 
			
		}
		return s;
	}

	@Override
	public void fill(ArrayList<T> list) {
		//Copy list 
		ArrayList<T> copy = new ArrayList<T>(list.size());
		for(T i : list) {
			copy.add(i);
		}
		
		//push the elements of copy to stack
		for(T i : copy) {
			stack.add(i);
		}		
	}

}
