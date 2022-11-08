package SumINBinarySearchTree;
import java.util.Scanner;
import java.util.ArrayList;

public class BinarySearchTree {
	ArrayList<Integer> nodelist = new ArrayList<>();
	private static nodeBST newNode(int n) {
		nodeBST temp = new nodeBST();
		temp.left = null;
		temp.data = n;
		temp.right = null;
		
		return temp;
	}
	
	private void insert(nodeBST root,nodeBST nn) {
		if(nn.data < root.data) 
		{
			if(root.left == null) 
			{
				root.left =nn;
			} 
			else 
			{
				insert(root.left, nn);
			}
		} 
		
		else 
		{
			if(root.right == null) 
			{
				root.right =nn;
			} 
			else 
			{
				insert(root.right, nn);
			}		
		}
	}
	
	private void traverse(nodeBST root) {  
		if(root != null) 
		{
			traverse(root.left);   
			nodelist.add(root.data);
			traverse(root.right);
		}	
	}

	public static void main(String args[])
	{	
		BinarySearchTree bst = new BinarySearchTree();
		nodeBST root = null;
		nodeBST nn = null; 
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		int A = sc.nextInt(); 
		
		int i;
		for(i = 1; i<=A; i++)
		{
			System.out.println("Enter Data for the node");
			int n = sc.nextInt();
			nn = newNode(n);
			if(root == null) 
			{
				root = nn;
			}
			else { 
				bst.insert(root, nn);
			}
		}
		
		bst.traverse(root);
		System.out.println(bst.nodelist);
		
		System.out.println("Enter sum");
		int sum = sc.nextInt();
		
		int flag = 0; 
		
		for(int j = 0; j <bst.nodelist.size(); j++) 
		{	
			 
			int n1 = bst.nodelist.get(j);
			int n2 = sum - n1;            
			if(bst.nodelist.contains(n2))
			{
				System.out.print("Found");
				System.out.print("[" + n1+ ", " +n2 + "]");
				flag=1;
				break;
			}
		}
		if(flag==0) {
			System.out.println("Not Found");
		}
		sc.close();
	}
}


