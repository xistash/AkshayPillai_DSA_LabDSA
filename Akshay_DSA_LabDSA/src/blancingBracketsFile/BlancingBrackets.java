package blancingBracketsFile;
import java.util.*;
import java.util.Stack;

public class BlancingBrackets {
	
		//check if string is balanced or not
	
		private static boolean Checkbracket(String input) {
			
			Stack<Character> stack = new Stack<>();
			
			
			for(char k: input.toCharArray())
			{	
				if(k == '{' || k == '[' || k == '(')
				{
					stack.push(k);
					continue;
				}
				if(stack.isEmpty())
					return false; 
			
				char z;
				switch(k)
				{
				case '}' :
						z = stack.pop();
						if(z == '[' || z == '(')
							return false;
						break;
						
				case ']' :
					z = stack.pop();
					if(z == '{' || z == '(')
						return false;
					break;
					
				case ')' :
					z = stack.pop();
					if(z == '[' || z == '{')
						return false;
					break;		
				} 
			}  
			return(stack.isEmpty());
		}
		
		
		public static void main(String[] args) {
			String input = "";
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter your equation");
			input = sc.next();
			
			 
			if(input.length() % 2 !=0)
			{
				System.out.println("Incomplete equation");
			}
			else
			{
				if(Checkbracket(input))
				{
					System.out.println("Balanced equation");
				}
				else
				{
					System.out.println("UnBalanced equation");
				}
			}
			sc.close();
		}
		
}
	
	

