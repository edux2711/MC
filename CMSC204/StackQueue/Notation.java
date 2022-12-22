package assignment2;

public class Notation {
	
	public static String convertInfixToPostfix​(String infix) throws InvalidNotationFormatException{
		//Create a queue instance to hold the postfix notation
		MyQueue<Object> postfix = new MyQueue<>();
		//Create a stack to hold characters and convert infix to postfix
		MyStack<Object> stack = new MyStack<>();
		
		try {
			//loop through each character of infix String
			for (Character c : infix.toCharArray()) {
				
				//If the current character in the infix is a digit, 
				if (Character.isDigit(c)) {
					//copy to the postfix queue
						postfix.enqueue(c); 
				} 
				//If the current infix character is a left parenthesis 
				else if(c.compareTo('(') == 0) {
					//push it onto the stack 
						stack.push(c);
				} 
				//If the current character in the infix is an operator, 
				else if(isThereAnOperator(c)) {

					if(stack.isEmpty() == false) {
						//Pop operators (if there are any) at the top of the stack while they have 
				 		//equal or higher precedence than the current operator, 
						if(isThereAnOperator(stack)) {
							//insert the popped operators in postfix solution queue
							postfix.enqueue(stack.pop()); 

						}
					}
					//Push the current character in the infix onto the stack 
					stack.push(c);
				} 
				//If the current character in the infix is a right parenthesis 
				else if (c.compareTo(')') == 0) {

					//until a left parenthesis is at the top of the stack
					while (stack.top().equals('(') == false) {
						//Pop operators from the top of the stack and insert them in postfix queue
						postfix.enqueue(stack.pop()); 

						//if top of stack is not a "(" after popping an operator, throw invalid format exception
						if (stack.isEmpty() || stack.top().equals('(') == false) {
							throw new InvalidNotationFormatException();
						}
					}
					stack.pop();
				}	
			}
			
			//if there is an operator on the stack, pop it and add it to the queue
			if(isThereAnOperator(stack)) {
				postfix.enqueue(stack.pop());
			}
			
		} catch (StackOverflowException soe) {
			System.out.println(soe.getMessage());
		} catch (QueueOverflowException qoe) {
			System.out.println(qoe.getMessage());
		} catch (StackUnderflowException sue) {
			System.out.println(sue.getMessage());
		}
		
		return postfix.toString();
	}
	
	public static String convertPostfixToInfix​(String postfix) throws InvalidNotationFormatException{
		//Create a stack to hold characters and convert infix to postfix
		MyStack<Object> stack = new MyStack<>();

		try {
			//loop through each character of infix String
			for (Character c : postfix.toCharArray()) {
				//if the current character is an operand
				if(Character.isDigit(c)) {
					//push to stack
					stack.push(c);
				} else if (isThereAnOperator(c)) {
					
					//if the stack has less than 2 values, throw an error
					if(stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}

					//Pop the top 2 values from the stack. 
					String first = stack.pop().toString(), 
						   second = stack.pop().toString(),
						   
						   //Create a string with 1st value and then the operator and then the 2nd value and
						   //encapsulate the resulting string within parenthesis
						   result = "(" + second + c + first + ")";
					//Push the resulting string back to the stack
					stack.push(result);	
				}
			}
			
		} catch(StackOverflowException soe) {
			System.out.println(soe.getMessage());
		} catch (StackUnderflowException sue) {
			System.out.println(sue.getMessage());
		}
		
		//If there is only one value in the stack – it is the infix string, 
		if(stack.size() == 1) {
			return stack.toString();
		} 
		//if more than one value, throw an error
		else {
			throw new InvalidNotationFormatException();
		}
		
	}
	
	public static double evaluatePostfixExpression​(String postfixExpr) throws InvalidNotationFormatException{
		//Create a stack to hold characters and convert infix to postfix
		MyStack<Object> stack = new MyStack<>();
		Double postfixResult = 0.0;
		int count = 0;
		try {
			//loop through each character of postfixExpr String
			for (Character c : postfixExpr.toCharArray()) {
				System.out.println("c: " + c);
				System.out.println("Count: " + count++);
				//If the current character is an operand or left parenthesis
				if(Character.isDigit(c) || c.equals('(')) {
					//push on the stack
					stack.push(c);
				}
				//if the character is an operator
				else if(isThereAnOperator(c)) {
					//If there are fewer than 2 values throw an error
					if(stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					
					//Pop the top 2 values from the stack and store them as a string
					String firstStr = stack.pop().toString(), 
						   secondStr = stack.pop().toString();
					
					//Convert the strings to double values
					Double first = Double.parseDouble(firstStr),
						   second = Double.parseDouble(secondStr);
					
					System.out.println("First: " + first);
					System.out.println("Second: " + second);

					//Perform the arithmetic calculation of the operator with the first popped value as the right operand and the second popped value as the left operand
					Double result = 0.0;
					if(c.compareTo('*') == 0)
						result = second * first;
					else if (c.compareTo('/') == 0)
						result = second / first;
					else if (c.compareTo('+') == 0)
						result = second + first;
					else 
						result = second - first;
					
					//Push the resulting value onto the stack
					stack.push(result);	
					System.out.println("Result!!!!!!: " + stack.top());
				}
			}
			
			//If there is only one value in the stack – it is the postfix string, 
			if(stack.size() == 1) {
				postfixResult += (double) stack.top();
				return postfixResult;
			} 
			//if more than one value, throw an error
			else {
				throw new InvalidNotationFormatException();
			}
			
		} catch(StackOverflowException soe) {
			System.out.println(soe.getMessage());
		} catch (StackUnderflowException sue) {
			System.out.println(sue.getMessage());
		}
		return postfixResult;
	}
	
	//takes a generic type and returns true if an operator is found, otherwise return false
	public static <T> boolean isThereAnOperator(T list) {
		
		//if list is an instance of MyStack, check the top and return true if it is and operator
		if (list instanceof MyStack) {
			MyStack<Character> a = (MyStack) list;
			if(a.top().equals('*') || a.top().equals('/') ||
			   a.top().equals('+') || a.top().equals('-')) {	
				return true;
			}
		} 
		//if list is an instance of Character, check the char and return true if it is an operator
		else if(list instanceof Character) {
			Character c = (Character) list;
			if(c.compareTo('*') == 0 || c.compareTo('/') == 0 
			|| c.compareTo('+') == 0 || c.compareTo('-') == 0) {
				return true;
			}
		}
		return false;
	}
}
