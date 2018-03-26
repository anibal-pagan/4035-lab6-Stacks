package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		SLLStack<String> stack = new SLLStack<>();
		for(int i=0; i<s.length(); i++){
			if((stack.isEmpty() || s.substring(i, i+1).matches("[A-Z]"))) 
				stack.push(s.substring(i,i+1));
			else if(s.substring(i, i+1).equalsIgnoreCase(stack.top())) stack.pop();
		}
		if(stack.isEmpty()) return true;
		else return false;
	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		if(!isValidContent()) throw new StringIsNotSymmetricException
		("parenthesizedExpression(): String must be symmetric.");
		String expression = "";
		for(int i=0; i<s.length(); i++){
			if(s.substring(i, i+1).matches("[A-Z]")) 
				expression += "<" + s.substring(i, i+1) + " ";
			else 
				expression += s.substring(i, i+1) + ">" + " ";
		}
		return expression;
	}

}
